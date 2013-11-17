package samssi.oshopper.domain.service

import samssi.oshopper.domain.Product
import samssi.oshopper.repository.MongoRepository

class ProductService {
  val mongoRepository = new MongoRepository
  def add(product: Product) {
    mongoRepository.insert(product.asJson)
  }
}

object HelloWorld {
  def main(args: Array[String]) {
    new ProductService().add(Product(1, "Nice - Shoe", 12.3D, "EUR", 24.00D))
  }
}
