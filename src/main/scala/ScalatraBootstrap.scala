import com.example.app._
import org.scalatra._
import javax.servlet.ServletContext
import com.example.app.SlickInit._

class ScalatraBootstrap extends LifeCycle  {

  override def init(context: ServletContext) {
    SlickInit
    context.mount(new UsersController, "/users/*")
  }

  override def destroy(context: ServletContext) {
    SlickInit.closeDbConnections()
  }
}
