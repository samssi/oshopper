package samssi.oshopper.domain

case class ShoppingCart(items: List[Product])
case class Product(id: Long, name: String, price: Double, currency: String, taxPercentage: Double, quantity: Int)
