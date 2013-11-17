package samssi.oshopper.repository

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoClientURI
import com.mongodb.util.JSON._

class MongoRepository {
  lazy val centralClient = MongoClient(MongoClientURI("mongodb://xxx:xxx@xxx.mongolab.com:53958/central"))
  def insert(product: String) {
    val products = centralClient("central").getCollection("products")
    val document = parse(product).asInstanceOf[DBObject]
    products.insert(document)
  }

  def select() {

  }
}
