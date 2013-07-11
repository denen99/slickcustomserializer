package com.example.app

import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import com.example.app.models._
import com.example.app.serializers.UserSerializer


class UsersController extends ScalatraServlet with JacksonJsonSupport  {

  implicit val jsonFormats = DefaultFormats + new UserSerializer

  before() {
    contentType = formats("json")
  }

  get("/:id") {
    val userid = params.getOrElse("id", halt(400)).toInt
    User.find(userid) match {
      case Some(u) => u
      case _ => halt(404, "No such user")
    }
  }

  get ("/") {
    User.findAll
  }
  
}
