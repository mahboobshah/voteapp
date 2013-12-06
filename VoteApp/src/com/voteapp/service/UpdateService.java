package com.voteapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class UpdateService {
	
	public void updateOptionScore(String voteId, int optionId) {
		
		Connection connection = null;
		try {

			connection = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");

			if(!connection.isClosed()){

				System.out.println("Successfully connected to" + " MySql Service using TCP/IP");

			}

			String optionUpdate = "update vote.options set oscore=oscore+1 where vid = '"+voteId+"' and oid = "+ optionId+";";
			java.sql.PreparedStatement st = connection.prepareStatement(optionUpdate);

			int rs2 = st.executeUpdate();
			
			if(rs2==0){
				throw new SQLDataException();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}
	
}
