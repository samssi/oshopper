package samssi.oshopper.domain

import org.bson.types.ObjectId
import org.json4s.native.Serialization._

trait MongoObject extends DefaultJson {
  def asJson: String = write(this)
}
case class ShoppingCart(items: List[Product]) extends MongoObject
case class Product(_id: Option[ObjectId], name: String, price: Double, currency: String, taxPercentage: Double) extends MongoObject
