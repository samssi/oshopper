package samssi.oshopper.domain.service

import samssi.oshopper.domain.Product
import samssi.oshopper.repository.MongoRepository
import org.bson.types.ObjectId

class ProductService {
  val mongoRepository = new MongoRepository
  def add(product: Product) {
    mongoRepository.insert(product.asJson)
  }
  def get(id: String): String = {
    parse(mongoRepository.select(id))
  }
}

object HelloWorld {
  def main(args: Array[String]) {
    //new ProductService().add(Product(None, "Nice - Shoe", 12.3D, "EUR", 24.00D))
    println(new ProductService().get("5288f09f0364a4456c0b26ab"))
  }
}
