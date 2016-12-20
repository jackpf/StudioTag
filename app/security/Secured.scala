package security

import javax.inject.Inject

import play.api.mvc._

import scala.concurrent.Future
import play.api.Logger

/**
  * Created by farrellyja on 20/12/2016.
  */
trait Secured {
  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(controllers.routes.LoginController.login)

  def SecuredAction(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
      Action(request => f(user)(request))
    }
  }
}