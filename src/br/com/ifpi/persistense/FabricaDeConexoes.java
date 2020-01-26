package br.com.ifpi.persistense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

	public Connection getConnection(String user, String pass){
		try {
			return DriverManager.getConnection
					("jdbc:mysql://localhost/dbBanco",user,pass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
