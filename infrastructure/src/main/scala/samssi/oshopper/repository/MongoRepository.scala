package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._

class MongoRepository {
  lazy val mongoUri = PropertiesUtil.getMongoUri
  lazy val centralClient = MongoClient(MongoClientURI(mongoUri))
  def insert(product: String) {
    val products = centralClient("central").getCollection("products")
    val document = parse(product).asInstanceOf[DBObject]
    products.insert(document)
  }

  def select() {

  }
}