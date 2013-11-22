package samssi.oshopper.domain.service

import samssi.oshopper.domain.{Customer, Product}
import samssi.oshopper.repository.{CustomerRepository, ProductRepository}
import org.bson.types.ObjectId
import org.json4s.native.JsonMethods._
import com.mongodb.DBCollection
import samssi.oshopper.domain.factory.ProductFactory
import samssi.oshopper.general.Json4sSettings

class ProductService extends Json4sSettings {
  val productRepository = new ProductRepository
  def add(product: Product) { productRepository.insert(product.asJson) }

  def getProductBy(id: String): Product = ProductFactory.asSingleProduct(productRepository.select(id))
  def getAllCategories = ProductFactory.asCategories(productRepository.getCategories)
  def getAllProducts(): List[Product] = sortByName(ProductFactory.asListOfProducts(productRepository.getAllProducts))

  def searchForProduct(searchWord: String) = sortByName(ProductFactory.asListOfProducts(productRepository.searchForProducts(searchWord)))

  def removeProductBy(id: String) { productRepository.delete(id) }

  private def sortByName(products: List[Product]) = products.sortWith(_.name.toLowerCase < _.name.toLowerCase)
}

class CustomerService extends Json4sSettings {
  val customerRepository = new CustomerRepository
  def add(customer: Customer) { customerRepository.insert(customer.asJson) }
}
