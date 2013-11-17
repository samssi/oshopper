package samssi.oshopper.servlet

import org.scalatra.{Ok, ScalatraServlet}

class EchoResource extends ScalatraServlet {
  get("/ping") {
    Ok("pong")
  }
}
