package controllers

import javax.inject.Inject

import play.api.libs.json.JsValue
import play.api.mvc.{Action, AnyContent, Controller}

/**
  * Created by farrellyja on 19/12/2016.
  */
class Application @Inject() extends Controller {
  def upload = Action {
    Ok(views.html.form.upload())
  }

  def test = Action { request =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] = body.asJson

    // Expecting json body
    jsonBody.map { json =>
      Ok("Got: " + (json \ "name").as[String])
    }.getOrElse {
      BadRequest("Expecting application/json request body")
    }
  }
}
