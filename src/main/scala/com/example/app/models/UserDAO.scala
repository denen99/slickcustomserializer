package com.example.app.models

import com.example.app.SlickInit
import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession
//import scala.slick.jdbc.{GetResult, StaticQuery => Q}
//import Q.interpolation





object UserDAO  {

  def find(id: Int): Option[User] = {
    SlickInit.dbMaster withSession {
            val q = for {
              x <- Users if x.id === id
            } yield x
            q.firstOption.map { case(id,email) =>  User(id,email) }
    }
  }

  def findAll: List[User] = {
    SlickInit.dbMaster withSession {
      val q = for {
        x <- Users
      } yield x
      q.list.map { case(id,email) =>  User(id,email) }
    }
  }

}

