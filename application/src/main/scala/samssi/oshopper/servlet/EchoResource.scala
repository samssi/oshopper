package samssi.oshopper.servlet

import org.scalatra.Ok
import samssi.oshopper.domain.Echo

class EchoResource extends OshopperServletSupport {
  get("/ping") {
    logger.info("Received ping with following params: " + params)
    Ok(Echo("pong"))
  }
}
