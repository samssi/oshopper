package samssi.oshopper.servlet

import samssi.oshopper.domain.factory.{CustomerFactory, ProductFactory}
import samssi.oshopper.domain.service.{CustomerService, ProductService}
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
    val product = ProductFactory.asSingleProduct(request.body)
    println(product)
    productService.add(product)
    Ok
  }
}

class CustomerResource extends OshopperServletSupport {
  val customerService: CustomerService = new CustomerService

  post("/") {
    println("POST - Received: " + request.body)
    val customer = CustomerFactory.asSingleCustomer(request.body)
    println(customer)
    customerService.add(customer)
    Ok
  }
}
