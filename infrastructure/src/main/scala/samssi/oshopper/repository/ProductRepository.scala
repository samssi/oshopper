package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId

trait CentralRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  def repositoryCollection: String
  def fetchCollectionFromDb(collection: String) = centralClient("central").getCollection(collection)
  def insert(json: String) { fetchCollectionFromDb(repositoryCollection).insert(parse(json).asInstanceOf[DBObject]) }
  def select(id: String) = fetchCollectionFromDb(repositoryCollection).findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = fetchCollectionFromDb(repositoryCollection).remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
}

class ProductRepository extends CentralRepository {
  def repositoryCollection = "products"
  def getCategories = fetchCollectionFromDb("products").distinct("category").toString
  def getAllProducts = fetchCollectionFromDb("products").find().toArray.toString
}

class CustomerRepository extends CentralRepository {
  def repositoryCollection = "customers"
}
