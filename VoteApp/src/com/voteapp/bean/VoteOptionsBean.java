package com.voteapp.bean;

public class VoteOptionsBean {
	
	private int optionId;
	private String voteId;
	private String optionDesc;
	private int optionScore;
	private String voteDesc;
	private int optionCount;
	
	public int getOptionId() {
		return optionId;
	}
	
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	
	public String getVoteId() {
		return voteId;
	}
	
	public void setVoteId(String voteId) {
		this.voteId = voteId;
	}
	
	public String getOptionDesc() {
		return optionDesc;
	}
	
	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}
	
	public int getOptionScore() {
		return optionScore;
	}
	
	public void setOptionScore(int optionScore) {
		this.optionScore = optionScore;
	}

	public String getVoteDesc() {
		return voteDesc;
	}

	public void setVoteDesc(String voteDesc) {
		this.voteDesc = voteDesc;
	}

	public int getOptionCount() {
		return optionCount;
	}

	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
}
