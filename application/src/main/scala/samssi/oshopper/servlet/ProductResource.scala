package samssi.oshopper.servlet

class ProductResource extends OshopperServletSupport {
  get("/") {
    println("GET - Received: " + params)
  }

  post("/") {
    println("POST - Received: " + params)
  }
}
