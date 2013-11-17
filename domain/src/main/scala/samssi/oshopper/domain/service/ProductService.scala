package samssi.oshopper.domain.service

import samssi.oshopper.domain.{DefaultJson, Product}
import samssi.oshopper.repository.MongoRepository
import org.bson.types.ObjectId
import org.json4s.native.JsonMethods._
import com.mongodb.DBCollection
import samssi.oshopper.domain.factory.ProductFactory

class ProductService extends DefaultJson {
  val mongoRepository = new MongoRepository
  def add(product: Product) {
    mongoRepository.insert(product.asJson)
  }
  def get(id: String): Product = {
    ProductFactory.asSingleProduct(mongoRepository.select(id))
  }
}



object HelloWorld {
  def main(args: Array[String]) {
    //new ProductService().add(Product(None, "Nice - Shoe", 12.3D, "EUR", 24.00D))
    println(new ProductService().get("5288f09f0364a4456c0b26ab")._id.getOrElse())
    println(new ProductService().get("5288f09f0364a4456c0b26ab"))
  }
}
