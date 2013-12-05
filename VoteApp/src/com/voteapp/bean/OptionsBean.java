package com.voteapp.bean;

public class OptionsBean {
	
	private int optionId;
	private String voteId;
	private String optionDesc;
	private int optionScore;
	
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
}
