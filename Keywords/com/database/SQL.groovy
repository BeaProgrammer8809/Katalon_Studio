package com.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

public class SQL {

	private static Connection connection = null;

	//Connect To DB

	@Keyword

	def connectDB(String url, String dbname, String port, String username, String password){

		String conn = "jdbc:sqlserver://" + url + ";databaseName=" + dbname + ";user=" +username+";password="+password



		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = DriverManager.getConnection(conn)

		return connection

	}

	// SELECT QUERY

	@Keyword

	def executeQuery(String queryString) {

		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs

	}

	//Close Connection

	@Keyword

	def closeDatabaseConnection() {

		if(connection != null && !connection.isClosed()){

			connection.close()

		}

		connection = null

	}

	//Execute Query like INSERT, UPDATE, DELETE

	@Keyword

	def execute(String queryString) {

		Statement stm = connection.createStatement()

		boolean result = stm.execute(queryString)

		return result

	}

}
