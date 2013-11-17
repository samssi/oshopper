package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._
import org.bson.types.ObjectId

class MongoRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  val products = centralClient("central").getCollection("products")

  def insert(product: String) { products.insert(parse(product).asInstanceOf[DBObject]) }
  def select(id: String) = products.findOne(ObjectId.massageToObjectId(id)).toString
  def getCategories = products.distinct("category").toString
}
