package samssi.oshopper.domain

import org.json4s.native.Serialization._
import org.json4s.DefaultFormats

trait JsonSerializable {
  implicit val jsonFormats = DefaultFormats
  def asJson: String = write(this)
}
case class ShoppingCart(items: List[Product]) extends JsonSerializable
case class Product(id: Long, name: String, price: Double, currency: String, taxPercentage: Double) extends JsonSerializable
