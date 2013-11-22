package samssi.oshopper.servlet

import samssi.oshopper.domain.factory.{CustomerFactory, ProductFactory}
import samssi.oshopper.domain.service.{CustomerService, ProductService}
import org.scalatra.{BadRequest, Ok}
import scala.util.Try
import samssi.oshopper.domain.ValidationException

class ProductResource extends OshopperServletSupport {
  val productService: ProductService = new ProductService

  get("/") {
    logger.info("GET - Received: " + params)
    params.get("searchword") match {
      case Some(searchWord) => {
        val products: List[Product] = productService.searchForProduct(searchWord)
        logger.info("Searching for: " + searchWord + " found: " + products);
        Ok(products)
      }
      case None => Ok(productService.getAllProducts());
    }
  }

  post("/") {
    logger.info("POST - Received: " + request.body)
    val product = ProductFactory.asSingleProduct(request.body)
    logger.info(product)
    productService.add(product)
    Ok
  }
}

class CustomerResource extends OshopperServletSupport {
  val customerService: CustomerService = new CustomerService

  post("/") {
    logger.info("POST - Received: " + request.body)
    val customer = CustomerFactory.asSingleCustomer(request.body)
    logger.info(customer)
    customerService.add(customer)
    Ok
  }
}
