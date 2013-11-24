package samssi.oshopper.domain

import org.bson.types.ObjectId
import org.json4s.native.Serialization._
import org.json4s.JsonAST.{JField, JValue}
import samssi.oshopper.general.Json4sSettings

trait JsonSerializable extends Json4sSettings {
  def asJson: String = write(this)
}
case class Order(customer: Customer, shoppingCart: ShoppingCart)
case class ShoppingCart(items: List[Product]) extends JsonSerializable
case class Product(id: Option[String], name: String, price: Double, currency: String, taxpercentage: Double, category: String) extends JsonSerializable

case class Customer(id: Option[String], firstname: String, lastname: String, email: String, phonenumber: String) extends  JsonSerializable
