package com.example.app.models

import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession
import com.example.app.SlickInit._


case class User(id:Int, email: String)


// DB Table
object Users extends Table[(Int,String)]("users") {
  def id = column[Int]("id")
  def email = column[String]("email")
  def * = id ~ email // <> (User, User.unapply _)

}

object User {

  def find(id: Int): Option[User] = UserDAO.find(id)

  def findAll = UserDAO.findAll


}
