import javax.servlet.ServletContext
import org.scalatra.LifeCycle
import samssi.oshopper.servlet.EchoResource

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) = {
    context.mount(new EchoResource, "/oshopper/v1/echo")
  }
}
