package com.sumit.jdbc;

import java.sql.SQLException;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select * from emp"));
	}

}
