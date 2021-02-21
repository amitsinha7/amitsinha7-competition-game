package com.competition.game.webservices.api.v1;

public class Topper implements Comparable<Topper> {

	int solvedTasks;
	String nickName;
	int successfulAttempt;

	public Topper(int solvedTasks, String nickName) {
		super();
		this.solvedTasks = solvedTasks;
		this.nickName = nickName;
	}

	public Topper(int solvedTasks, String nickName, int successfulAttempt) {
		super();
		this.solvedTasks = solvedTasks;
		this.nickName = nickName;
		this.successfulAttempt = successfulAttempt;
	}



	@Override
	public int compareTo(Topper o) {
		if (this.getSolvedTasks() == o.getSolvedTasks())
			return 0;
		else if (this.getSolvedTasks() > o.getSolvedTasks())
			return 1;
		else
			return -1;
	}

	public int getSolvedTasks() {
		return solvedTasks;
	}

	public void setSolvedTasks(int solvedTasks) {
		this.solvedTasks = solvedTasks;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getSuccessfulAttempt() {
		return successfulAttempt;
	}

	public void setSuccessfulAttempt(int successfulAttempt) {
		this.successfulAttempt = successfulAttempt;
	}

	

}
