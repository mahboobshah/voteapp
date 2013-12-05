package com.voteapp.bean;

import java.sql.Timestamp;

public class VoteBean {
	
	private String voteId;
	private String voteDesc;
	private int optionCount;
	private Timestamp voteEnds;
	private OptionsBean[] options;
	
	public String getVoteId() {
		return voteId;
	}
	
	public void setVoteId(String voteId) {
		this.voteId = voteId;
		//this.voteId = "sample";
	}
	
	public String getVoteDesc() {
		return voteDesc;
	}
	
	public void setVoteDesc(String voteDesc) {
		this.voteDesc = voteDesc;
		//this.voteDesc = "Sample Vote";
	}
	
	public int getOptionCount() {
		return optionCount;
	}
	
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
		//this.optionCount = 1;
	}

	public OptionsBean[] getOptions() {
		return options;
	}

	public void setOptions(OptionsBean[] options) {
		this.options = options;
	}

	public Timestamp getVoteEnds() {
		return voteEnds;
	}

	public void setVoteEnds(Timestamp voteEnds) {
		this.voteEnds = voteEnds;
	}

}
