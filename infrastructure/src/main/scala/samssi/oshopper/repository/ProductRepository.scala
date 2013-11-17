package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId

class ProductRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  val productsCollection = centralClient("central").getCollection("products")
  
  def insert(product: String) { productsCollection.insert(parse(product).asInstanceOf[DBObject]) }
  def select(id: String) = productsCollection.findOne(ObjectId.massageToObjectId(id)).toString
  def delete(id: String) = productsCollection.remove(DBObject("_id" -> ObjectId.massageToObjectId(id)))
  def getCategories = productsCollection.distinct("category").toString
}
