package samssi.oshopper.domain

import org.json4s.DefaultFormats

trait DefaultJson {
  implicit val jsonFormats = DefaultFormats
}
