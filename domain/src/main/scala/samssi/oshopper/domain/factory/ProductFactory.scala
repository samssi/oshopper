package samssi.oshopper.domain.factory

import org.json4s.native.JsonMethods._
import samssi.oshopper.domain.{ShoppingCart, Customer, Product}
import samssi.oshopper.general.Json4sSettings

//TODO: Use generics
object ProductFactory extends Json4sSettings {
  def asSingleProduct(json: String): Product = parse(json).extract[Product]
  def asListOfProducts(json: String): List[Product] = parse(json).extract[List[Product]]

  def asCategories(json: String) = parse(json).extract[List[String]]
}

object CustomerFactory extends Json4sSettings {
  def asSingleCustomer(json: String): Customer = parse(json).extract[Customer]
}

object ShoppingCartFactory extends Json4sSettings {
  def asShoppingCart(json: String): ShoppingCart = parse(json).extract[ShoppingCart]
}
