package samssi.oshopper.servlet

import org.scalatra.Ok
import samssi.oshopper.domain.Echo

class EchoResource extends OshopperServletSupport {
  get("/ping") {
    Ok(Echo("pong"))
  }
}
