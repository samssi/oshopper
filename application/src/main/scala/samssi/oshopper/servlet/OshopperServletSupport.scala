package samssi.oshopper.servlet

import org.scalatra.{CorsSupport, ScalatraServlet}
import org.scalatra.json.NativeJsonSupport
import org.json4s.DefaultFormats

trait OshopperServletSupport extends ScalatraServlet with NativeJsonSupport with CorsSupport {
  implicit override val jsonFormats = DefaultFormats
  before() {
    contentType = formats("json")
  }
}
