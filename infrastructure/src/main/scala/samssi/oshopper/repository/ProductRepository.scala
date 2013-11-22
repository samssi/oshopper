package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId
import samssi.oshopper.general.{Json4sSettings, Logging}
import org.json4s.native.JsonMethods.{parse => json4sParse}
import org.json4s.native.Serialization._
import com.mongodb.util.JSON.parse

trait CentralRepository extends Json4sSettings {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  def repositoryCollection: String
  def fetchCollectionFromDb(collection: String) = centralClient("central").getCollection(collection)
  def insert(json: String) { fetchCollectionFromDb(repositoryCollection).insert(parse(json).asInstanceOf[DBObject]) }
  def select(id: String) = fetchCollectionFromDb(repositoryCollection).findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = fetchCollectionFromDb(repositoryCollection).remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
  def flattenId(json: String) = {
    val result = json4sParse(json).transformField {
      case("_id", x) => ("id", x \ "$oid")
    }
    write(result)
  }
}

class ProductRepository extends CentralRepository with Logging {
  val productsCollection = fetchCollectionFromDb("products")

  def repositoryCollection = "products"

  def getCategories = flattenId(productsCollection.distinct("category").toString)

  def getAllProducts = flattenId(productsCollection.find().toArray.toString)

  def searchForProducts(searchWord: String) = {
    val queryStart = System.currentTimeMillis()
    val nameSearchingObject = MongoDBObject("name" -> ("(?i)" + searchWord + "*").r)
    val result = productsCollection.find(nameSearchingObject).toArray().toString
    val queryStop = System.currentTimeMillis()
    logger.info("Query time: " + (queryStop - queryStart) + " (ms)")
    flattenId(result)
  }
}

class CustomerRepository extends CentralRepository {
  def repositoryCollection = "customers"
}
