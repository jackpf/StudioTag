package model.request

/**
  * Created by farrellyja on 20/12/2016.
  */
case class LoginRequest(username: String, password: String) {
  val validUsers = Map("root" -> "root")
  def authenticate = {
    validUsers.exists(_ == (username, password))
  }
}
