package controllers

import javax.inject.Inject

import model.request.LoginRequest
import play.api.libs.json.Json._
import play.api.libs.json.{JsSuccess, Json, Reads}
import play.api.mvc.BodyParsers.parse
import play.api.mvc.{Action, Controller, Security}
import security.Secured

/**
  * Created by farrellyja on 20/12/2016.
  */
class LoginController @Inject() extends Controller {
  def login = Action { implicit request =>
    Ok(views.html.login())
  }

  def loginProcess = Action(parse.json) { implicit request =>
    implicit val loginRequest: Reads[LoginRequest] = Json.reads[LoginRequest]

    request.body.validate[LoginRequest] match {
      case s: JsSuccess[LoginRequest] if (s.get.authenticate) => {
        Ok(toJson(Map("valid" -> true))).withSession(Security.username -> s.get.username)
      }
      case _ => Ok(toJson(Map("valid" -> false)))
    }
  }

  def logoutProcess = Action(parse.json) { implicit request =>
    Ok(toJson(Map("valid" -> true))).withNewSession
  }
}
