package samssi.oshopper.domain.service

import samssi.oshopper.domain.{DefaultJson, Product}
import samssi.oshopper.repository.ProductRepository
import org.bson.types.ObjectId
import org.json4s.native.JsonMethods._
import com.mongodb.DBCollection
import samssi.oshopper.domain.factory.ProductFactory

class ProductService extends DefaultJson {
  val mongoRepository = new ProductRepository
  def add(product: Product) { mongoRepository.insert(product.asJson) }
  def getProductBy(id: String): Product = ProductFactory.asSingleProduct(mongoRepository.select(id))
  def getAllCategories = ProductFactory.asCategories(mongoRepository.getCategories)
  def removeProductBy(id: String) { mongoRepository.delete(id) }
}



object HelloWorld {
  def main(args: Array[String]) {
    val productService: ProductService = new ProductService
    //productService.add(Product(None, "Nice", 119.99D, "EUR", 24.00D, "Shoes"))
    //productService.add(Product(None, "Mokia 1235", 99.99D, "EUR", 24.00D, "Mobile phones"))
    //productService.add(Product(None, "Mokia 2234", 199.99D, "EUR", 24.00D, "Mobile phones"))
    //productService.add(Product(None, "mCell 5s", 599.99D, "EUR", 24.00D, "Mobile phones"))
    //println(new ProductService().getProductBy("5288f09f0364a4456c0b26ab")._id.getOrElse())
    //println(new ProductService().getProductBy("5288f09f0364a4456c0b26ab").category)
    //val list: List[String] = productService.getAllCategories
    //list.map(_.toString).foreach(println _)
    //5288fc33036434c5ccdd7f6a
    //println(productService.getAllCategories)
    productService.removeProductBy("5288fc33036434c5ccdd7f6a")
  }
}
