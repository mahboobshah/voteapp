package com.voteapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voteapp.bean.OptionsBean;
import com.voteapp.bean.VoteBean;
import com.voteapp.service.RetrieveService;
import com.voteapp.service.UpdateService;

/**
 * Servlet implementation class UpdateVoteController
 */
@WebServlet("/UpdateVoteController")
public class UpdateVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateVoteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RetrieveService con = new RetrieveService();
		String voteId = request.getParameter("voteID");
		int optionId = Integer.parseInt(request.getParameter("chosenOption"));

		UpdateService con2 = new UpdateService();
		con2.updateOptionScore(voteId, optionId);

		VoteBean resultVote = con.getVoteDetails(voteId);

		String voteDesc = resultVote.getVoteDesc();
		OptionsBean[] options = resultVote.getOptions();
		int index = resultVote.getOptionCount();
		/*
		@SuppressWarnings("rawtypes")

		JSONArray jsonArray = new JSONArray();
		for(int i=0; i<options.length; i++){
			JSONObject jsonObj= new JSONObject();
			try{

				jsonObj.put("odesc", options[i].getOptionDesc());
				jsonObj.put("oscore", options[i].getOptionScore());

				jsonArray.put(jsonObj);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String jsonText = jsonArray.toString();
		System.out.println(jsonText);

		 */
		String voteID = request.getParameter("voteID");




		if(resultVote != null){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Result.jsp");

			request.setAttribute("voteDesc", voteDesc);
			request.setAttribute("options", options);
			request.setAttribute("countOptions", index);
			request.setAttribute("voteID", voteID);

			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Index.jsp");
			request.setAttribute("voteDesc", voteDesc);
			requestDispatcher.forward(request, response);
		}

	}

}
