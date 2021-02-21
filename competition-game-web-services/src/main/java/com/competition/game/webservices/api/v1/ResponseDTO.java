package com.competition.game.webservices.api.v1;

import java.util.List;

import com.competition.game.webservices.model.Player;
import com.competition.game.webservices.model.PreLoadedTask;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseDTO {

	private ErrorInfo errorInfo;

	private PreLoadedTask preLoadedTask;

	private List<Topper> toppers;

	public List<Topper> getToppers() {
		return toppers;
	}

	public void setToppers(List<Topper> toppers) {
		this.toppers = toppers;
	}

	private Player player;

	private String message;

	private List<PreLoadedTask> preLoadedTasks;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public PreLoadedTask getPreLoadedTask() {
		return preLoadedTask;
	}

	public void setPreLoadedTask(PreLoadedTask preLoadedTask) {
		this.preLoadedTask = preLoadedTask;
	}

	public List<PreLoadedTask> getPreLoadedTasks() {
		return preLoadedTasks;
	}

	public void setPreLoadedTasks(List<PreLoadedTask> preLoadedTasks) {
		this.preLoadedTasks = preLoadedTasks;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
