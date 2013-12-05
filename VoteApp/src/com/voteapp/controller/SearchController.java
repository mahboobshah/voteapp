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

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SearchController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String voteID = request.getParameter("voteID");
		
		RetrieveService con = new RetrieveService();
		
		VoteBean resultVote = con.getVoteDetails(voteID);
		
		String voteDesc = resultVote.getVoteDesc();
		OptionsBean[] options = resultVote.getOptions();
		int index = resultVote.getOptionCount();

		
		
		if(resultVote != null){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/VoteDetails.jsp");
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			}

}
