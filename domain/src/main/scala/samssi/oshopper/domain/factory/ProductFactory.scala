package samssi.oshopper.domain.factory

import org.json4s.native.JsonMethods._
import samssi.oshopper.domain.{DefaultJson, Product}

object ProductFactory extends DefaultJson {
  def asSingleProduct(dbCollection: String) = parse(dbCollection).extractOrElse[Product](throw new RuntimeException("Schema error"))
}
