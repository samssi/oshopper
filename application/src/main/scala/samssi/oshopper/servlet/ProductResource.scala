package samssi.oshopper.servlet

import samssi.oshopper.domain.factory.ProductFactory
import samssi.oshopper.domain.service.ProductService
import org.scalatra.{BadRequest, Ok}
import scala.util.Try
import samssi.oshopper.domain.ValidationException

class ProductResource extends OshopperServletSupport {
  val productService: ProductService = new ProductService
  get("/") {
    println("GET - Received: " + params)
  }

  post("/") {
    println("POST - Received: " + request.body)
    val result = Try(ProductFactory.asSingleProduct(request.body))
    println(ProductFactory.asSingleProduct(request.body))
    if (result.isSuccess) Ok
    else BadRequest
  }
}
