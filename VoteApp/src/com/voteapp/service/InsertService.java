package com.voteapp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.voteapp.bean.OptionsBean;
import com.voteapp.bean.VoteBean;

public class InsertService {

	public void voteInsertService(VoteBean vote){
		Connection connection = null;
		try {

			connection = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");

			if(!connection.isClosed()){

				System.out.println("Successfully connected to" + " MySql Service using TCP/IP");

			}

			String voteDescInsert = "INSERT INTO vote.vote VALUES (?,?,?,NULL)";
			java.sql.PreparedStatement st = connection.prepareStatement(voteDescInsert);
			st.setString(1, vote.getVoteId());
			st.setString(2, vote.getVoteDesc());
			st.setInt(3, vote.getOptionCount());

			st.executeUpdate();

			OptionsBean[] options = vote.getOptions();

			for(int i = 0; i < options.length; i++ ){

				String optionsInsert = "insert into vote.options values (?,?,?,?)";
				java.sql.PreparedStatement st2 = connection.prepareStatement(optionsInsert);

				st2.setInt(1, options[i].getOptionId());
				st2.setString(2, options[i].getVoteId());
				st2.setString(3, options[i].getOptionDesc());
				st2.setInt(4, options[i].getOptionScore());

				st2.executeUpdate();

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

	}

/*
	public VoteBean getVoteDetails(String voteId){
		
		Connection connection = null;
		ResultSet rs = null;

		rs = null;

		VoteBean newVoteBean = new VoteBean();

		try {
			
			connection = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			connection = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "password");

			if(!connection.isClosed()){

				System.out.println("Successfully connected to" + " MySql Service using TCP/IP");

			}


			String voteDescRead = "select vdesc from vote.vote where vid = '" + voteId + "'";
			java.sql.PreparedStatement st = connection.prepareStatement(voteDescRead);

			rs = st.executeQuery();

			if(rs.next()) {
				newVoteBean.setVoteDesc(rs.getString(1));
			} else {
				newVoteBean.setVoteDesc("error");
			}

			String optionsRead = "select o.oid,o.odesc,o.oscore from vote.vote v, vote.options o where o.vid = '"+ voteId + "' and v.vid = o.vid";
			java.sql.PreparedStatement st2 = connection.prepareStatement(optionsRead);

			ResultSet rs2 = null;
			rs2 = st2.executeQuery();
			ResultSet rs3 = rs2;

			int size = 0;
			rs3.last();
			size = rs3.getRow();
			rs3.beforeFirst();
			
			

			OptionsBean[] options = new OptionsBean[size];
			

			int i = 0;
			while(rs2.next()) {
				
				
				OptionsBean newOption = new OptionsBean();

				newOption.setOptionId(rs2.getInt(1));
				newOption.setOptionDesc(rs2.getString(2));
				newOption.setOptionScore(rs2.getInt(3));
				options[i] = newOption;
				
				//System.out.println("Options Test: "+options[i].getOptionDesc());
				i++;

			}
			
			newVoteBean.setOptions(options);


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return newVoteBean;

	}


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

	} */
	
}