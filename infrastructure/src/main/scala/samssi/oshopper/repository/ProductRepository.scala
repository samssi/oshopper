package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId

trait CentralRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  def collection(collection: String) = centralClient("central").getCollection(collection)
}

class ProductRepository extends CentralRepository {
  def insert(json: String) { collection("products").insert(parse(json).asInstanceOf[DBObject]) }
  def select(id: String) = collection("products").findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = collection("products").remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
  def getCategories = collection("products").distinct("category").toString
}

class CustomerRepository extends CentralRepository {
  def insert(json: String) { collection("customers").insert(parse(json).asInstanceOf[DBObject]) }
  def select(id: String) = collection("customers").findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = collection("customers").remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
}
