package samssi.oshopper.servlet

import org.scalatra.{Ok, ScalatraServlet}
import org.scalatra.json.NativeJsonSupport
import org.json4s.DefaultFormats
import samssi.oshopper.domain.echo.Echo

class EchoResource extends ScalatraServlet with NativeJsonSupport {
  implicit override val jsonFormats = DefaultFormats
  before() {
    contentType = formats("json")
  }

  get("/ping") {
    Ok(Echo("pong"))
  }
}
