package samssi.oshopper.domain.factory

import org.json4s.native.JsonMethods._
import samssi.oshopper.domain.{ValidationException, DefaultJson, Product}

object ProductFactory extends DefaultJson {
  def asSingleProduct(json: String): Product = parse(json).extract[Product]
  def asCategories(json: String) = parse(json).extract[List[String]]
}
