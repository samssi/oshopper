package samssi.oshopper.domain.service

import samssi.oshopper.domain.{Customer, DefaultJson, Product}
import samssi.oshopper.repository.{CustomerRepository, ProductRepository}
import org.bson.types.ObjectId
import org.json4s.native.JsonMethods._
import com.mongodb.DBCollection
import samssi.oshopper.domain.factory.ProductFactory

class ProductService extends DefaultJson {
  val productRepository = new ProductRepository
  def add(product: Product) { productRepository.insert(product.asJson) }
  def getProductBy(id: String): Product = ProductFactory.asSingleProduct(productRepository.select(id))
  def getAllCategories = ProductFactory.asCategories(productRepository.getCategories)
  def removeProductBy(id: String) { productRepository.delete(id) }
}

class CustomerService extends DefaultJson {
  val customerRepository = new CustomerRepository
  def add(customer: Customer) { customerRepository.insert(customer.asJson) }
}
