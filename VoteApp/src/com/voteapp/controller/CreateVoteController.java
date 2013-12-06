package com.voteapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import com.voteapp.bean.OptionsBean;
import com.voteapp.bean.VoteBean;
import com.voteapp.service.RetrieveService;
import com.voteapp.service.InsertService;

/**
 * Servlet implementation class CreateVoteController
 */
@WebServlet("/CreateVoteController")
public class CreateVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateVoteController() {
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
		
		String newVoteID = RandomStringUtils.randomAlphanumeric(4);
		int i = 0;
		String[] newOptionsDesc = request.getParameterValues("optionsData");
		int optionSize = newOptionsDesc.length;
		OptionsBean[] newOptions = new OptionsBean[optionSize+1];
		
		if(optionSize == 0){
			OptionsBean tempOpt = new OptionsBean();
			tempOpt.setVoteId(newVoteID);
			tempOpt.setOptionDesc("No Options for this poll.");
			tempOpt.setOptionId(1);
			tempOpt.setOptionScore(0);
			
			//System.out.println(newOptionsDesc[0]);
			
			newOptions[0]=tempOpt;
		}
		
		while( optionSize > 0){
			
			OptionsBean tempOpt = new OptionsBean();
			tempOpt.setVoteId(newVoteID);
			tempOpt.setOptionDesc(newOptionsDesc[i]);
			tempOpt.setOptionId(i+1);
			tempOpt.setOptionScore(0);
			
			//System.out.println(newOptionsDesc[i]);
			
		
			
			newOptions[i]=tempOpt;
			i++;
			optionSize--;
		}
		
		VoteBean newVote = new VoteBean();
		
		newVote.setVoteId(newVoteID);
		newVote.setVoteDesc(request.getParameter("voteDesc"));
		newVote.setOptions(newOptions);
		newVote.setOptionCount(newOptionsDesc.length);
//		newVote.setVoteEnds();

		InsertService con1 = new InsertService();
		
		con1.voteInsertService(newVote);
		
		RetrieveService con = new RetrieveService();
		
		VoteBean resultVote = con.getVoteDetails(newVoteID);
		
		String voteDesc = resultVote.getVoteDesc();
		OptionsBean[] options = resultVote.getOptions();
		int index = resultVote.getOptionCount();

		
		
		if(resultVote != null){
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/VoteDetails.jsp");
			
			request.setAttribute("voteDesc", voteDesc);
			request.setAttribute("options", options);
			request.setAttribute("countOptions", index);
			request.setAttribute("voteID", newVoteID);

			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Index.jsp");
			request.setAttribute("voteDesc", voteDesc);
			requestDispatcher.forward(request, response);
		}
		
	}

}
