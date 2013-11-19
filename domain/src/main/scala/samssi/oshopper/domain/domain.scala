package samssi.oshopper.domain

import org.bson.types.ObjectId
import org.json4s.native.Serialization._

trait JsonSerializable extends DefaultJson {
  def asJson: String = write(this)
}
case class ShoppingCart(items: List[Product]) extends JsonSerializable
case class Product(_id: Option[ObjectId], name: String, price: Double, currency: String, taxpercentage: Double, category: String) extends JsonSerializable
