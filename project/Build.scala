import sbt._
import sbt.Keys._
import scala._
import com.github.siasia.WebPlugin._

object MasterBuild extends Build {
  name := "mydddproject"

  lazy val buildSettings = Seq(
    organization := "samssi",
    version:= "1.0-SNAPSHOT",
    scalaVersion := "2.10.0"
  )

  override lazy val settings = super.settings ++ buildSettings ++ Seq(
    resolvers ++= Seq(
      "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases"
    )
  )

  lazy val root = Project(
    id = "parent",
    base = file(".")
  ).aggregate(infrastructure, domain, application)

  lazy val infrastructure = {
    Project(
      id = "infrastructure",
      base = file("infrastructure"),
      settings = generalSettings ++ Seq(
        libraryDependencies ++= Seq(
        )
      )
    )
  }

  lazy val domain = {
    Project(
      id = "domain",
      base = file("domain"),
      settings = generalSettings ++ Seq(
        libraryDependencies ++= Seq(
          "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"
        )
      )
    ).aggregate(infrastructure) dependsOn (infrastructure)
  }

  lazy val application = {
    Project(
      id = "application",
      base = file("application"),
      settings = generalSettings ++ serverSettings ++ Seq(
        libraryDependencies ++= Seq(
          "org.scalatra" %% "scalatra" % "2.2.1",
          "org.scalatra" %% "scalatra-scalatest" % "2.2.1" % "test",
          "org.scalatra" %% "scalatra-json" % "2.2.1",
          "org.scalatra" %% "scalatra-swagger" % "2.2.1"
        )
      )
    ).aggregate(infrastructure, domain) dependsOn (infrastructure, domain)
  }

  lazy val generalSettings = {
    Defaults.defaultSettings ++ Seq(
      libraryDependencies ++= Seq(
        "junit" % "junit" % "4.11" % "test",
        "log4j" % "log4j" % "1.2.17",
        "org.slf4j" % "slf4j-log4j12" % "1.7.5",
        "org.specs2" %% "specs2" % "2.2.2" % "test",
        "org.json4s" %% "json4s-native" % "3.1.0",
        "org.json4s"   %% "json4s-jackson" % "3.1.0"      )
    )
  }

  lazy val serverSettings = {
    webSettings ++ Seq(
      libraryDependencies ++= Seq(
        "org.eclipse.jetty" % "jetty-server" % "8.1.13.v20130916" % "container",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.13.v20130916" % "container",
        "org.eclipse.jetty" % "jetty-servlets" % "8.1.13.v20130916" % "container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "provided" artifacts (Artifact("javax.servlet", "jar", "jar"))
      )
    ) ++ buildSettings
  }
}
