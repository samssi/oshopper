package samssi.oshopper.servlet

import org.scalatra.{CorsSupport, ScalatraServlet}
import org.scalatra.json.NativeJsonSupport
import org.json4s.DefaultFormats
import samssi.oshopper.general.Logging

trait OshopperServletSupport extends ScalatraServlet with NativeJsonSupport with CorsSupport with Logging {
  implicit override val jsonFormats = DefaultFormats
  before() {
    contentType = formats("json")
  }
}
