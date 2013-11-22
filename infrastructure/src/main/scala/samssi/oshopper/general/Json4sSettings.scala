package samssi.oshopper.general

import org.json4s.DefaultFormats
import org.json4s.native.JsonMethods._

class Json4sSettings {
  implicit val jsonFormats = DefaultFormats

  def parseWithId(json: String) = {
    parse(json).transformField {
      case("_id", x) => ("id", x \ "$oid")
    }
  }
}
