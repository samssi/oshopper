package samssi.oshopper.domain.factory

import org.json4s.native.JsonMethods._
import samssi.oshopper.domain.{Customer, ValidationException, DefaultJson, Product}

object ProductFactory extends DefaultJson {
  def asSingleProduct(json: String): Product = parse(json).extract[Product]
  def asListOfProducts(json: String): List[Product] = parse(json).extract[List[Product]]
  def asCategories(json: String) = parse(json).extract[List[String]]
}

object CustomerFactory extends DefaultJson {
  def asSingleCustomer(json: String): Customer = parse(json).extract[Customer]
}
