package com.example.app

import org.scalatra.ScalatraServlet
import org.slf4j.LoggerFactory
import com.mchange.v2.c3p0.ComboPooledDataSource
import java.util.Properties
import scala.slick.session.Database

object SlickInit {

    val logger = LoggerFactory.getLogger(getClass)

    def createDataSource(name: String): ComboPooledDataSource = {
      val cpds = new ComboPooledDataSource(name)
      logger.info(f"Created c3p0 connection pool: $name")
      cpds
    }

    val cpdsMaster = createDataSource("master")
    val dbMaster = setupDB("master")

    def setupDB(instance: String): Database = instance match {
      case "master" => Database.forDataSource(cpdsMaster)
      case _ => Database.forDataSource(cpdsMaster)
    }

    def closeDbConnections() {
      logger.info("Closing c3p0 connection pool")
      cpdsMaster.close
    }

}
