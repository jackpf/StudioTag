package controllers

import javax.inject.Inject

import play.api.mvc.{Action, Controller}

/**
  * Created by farrellyja on 20/12/2016.
  */
class UploadController @Inject() extends Controller {
  def upload = Action {
    Ok(views.html.form.upload())
  }
}
