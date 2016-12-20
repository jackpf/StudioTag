package controllers

import javax.inject.Inject

import play.api.mvc.Controller
import security.Secured

/**
  * Created by farrellyja on 20/12/2016.
  */
class IndexController @Inject() extends Controller with Secured {
  def index = SecuredAction { username => implicit request =>
    Ok(views.html.index())
  }
}
