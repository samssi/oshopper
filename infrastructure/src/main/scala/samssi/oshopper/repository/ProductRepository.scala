package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId
import samssi.oshopper.general.Logging

trait CentralRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  def repositoryCollection: String
  def fetchCollectionFromDb(collection: String) = centralClient("central").getCollection(collection)
  def insert(json: String) { fetchCollectionFromDb(repositoryCollection).insert(parse(json).asInstanceOf[DBObject]) }
  def select(id: String) = fetchCollectionFromDb(repositoryCollection).findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = fetchCollectionFromDb(repositoryCollection).remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
}

class ProductRepository extends CentralRepository with Logging {
  val productsCollection = fetchCollectionFromDb("products")
  def repositoryCollection = "products"
  def getCategories = productsCollection.distinct("category").toString
  def getAllProducts = productsCollection.find().toArray.toString
  def searchForProducts(searchWord: String) = {
    val queryStart = System.currentTimeMillis()
    val result = productsCollection.find(MongoDBObject("name" -> ("(?i)" + searchWord + "*").r)).toArray().toString
    val queryStop = System.currentTimeMillis()
    logger.info("Query time: " + (queryStop - queryStart) + " (ms)")
    result
  }
}

class CustomerRepository extends CentralRepository {
  def repositoryCollection = "customers"
}
