package com.voteapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.voteapp.bean.OptionsBean;
import com.voteapp.bean.VoteBean;

public class VoteInsertService {

	public String voteInsertService(VoteBean voteDesc, OptionsBean[] options){

		int size = 0;

		try {

			Connection connection = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");

			if(!connection.isClosed()){

				System.out.println("Successfully connected to" + "MySql Service using TCP/IP");

			}

			String voteDescInsert = "INSERT INTO vote.vote VALUES (?,?,?)";
			java.sql.PreparedStatement st = connection.prepareStatement(voteDescInsert);
			st.setString(1, voteDesc.getVoteId());
			st.setString(2, voteDesc.getVoteDesc());
			st.setInt(3, voteDesc.getOptionCount());

			size = st.executeUpdate();

			for(int i = 0; i < options.length; i++ ){

				String optionsInsert = "insert into vote.options values (?,?,?,?)";
				java.sql.PreparedStatement st2 = connection.prepareStatement(optionsInsert);
				
				st2.setInt(1, options[i].getOptionId());
				st2.setString(2, options[i].getVoteId());
				st2.setString(3, options[i].getOptionDesc());
				st2.setInt(4, options[i].getOptionScore());
				
				size = st2.executeUpdate();

			}


		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NullPointerException e){

		}

		if(size == 1){	
			return "success";
		}else{
			return "failure";
		}		

	}
}
