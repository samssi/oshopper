package samssi.oshopper.servlet

import org.scalatra.ScalatraServlet
import org.scalatra.json.NativeJsonSupport
import org.json4s.DefaultFormats

trait OshopperServletSupport extends ScalatraServlet with NativeJsonSupport {
  implicit override val jsonFormats = DefaultFormats
  before() {
    contentType = formats("json")
  }
}
