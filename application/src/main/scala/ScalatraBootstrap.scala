import javax.servlet.ServletContext
import org.scalatra.LifeCycle
import samssi.oshopper.servlet.{CustomerResource, ProductResource, EchoResource}

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) = {
    context.mount(new EchoResource, "/oshopper/v1/echo")
    context.mount(new ProductResource, "/oshopper/v1/products")
    context.mount(new CustomerResource, "/oshopper/v1/customers")
  }
}
