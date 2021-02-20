package com.competition.game.webservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int taskId;

	@ManyToOne
	@JoinColumn(name = "language_number")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "player_Nick_Name")
	private Player player;

	@Column(name = "Description")
	@NotEmpty(message = "Task  Description is required")
	private String description;

	@Column(name = "Input")
	@NotEmpty(message = "Task  Input is required")
	private String input;

	@Column(name = "Output")
	@NotEmpty(message = "Language number is required")
	private String output;

	@Column(name = "CompilerArgs")
	private String compilerArgs;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getCompilerArgs() {
		return compilerArgs;
	}

	public void setCompilerArgs(String compilerArgs) {
		this.compilerArgs = compilerArgs;
	}

	public Task(int taskId, Language language, Player player,
			@NotEmpty(message = "Task  Description is required") String description,
			@NotEmpty(message = "Task  Input is required") String input,
			@NotEmpty(message = "Language number is required") String output, String compilerArgs) {
		super();
		this.taskId = taskId;
		this.language = language;
		this.player = player;
		this.description = description;
		this.input = input;
		this.output = output;
		this.compilerArgs = compilerArgs;
	}

	public Task() {
		super();
	}

	public Task(int taskId, @NotEmpty(message = "Task  Description is required") String description,
			@NotEmpty(message = "Task  Input is required") String input,
			@NotEmpty(message = "Language number is required") String output, String compilerArgs) {
		super();
		this.taskId = taskId;
		this.description = description;
		this.input = input;
		this.output = output;
		this.compilerArgs = compilerArgs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compilerArgs == null) ? 0 : compilerArgs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((input == null) ? 0 : input.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result + taskId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (compilerArgs == null) {
			if (other.compilerArgs != null)
				return false;
		} else if (!compilerArgs.equals(other.compilerArgs))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (input == null) {
			if (other.input != null)
				return false;
		} else if (!input.equals(other.input))
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		if (taskId != other.taskId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", language=" + language + ", player=" + player + ", description="
				+ description + ", input=" + input + ", output=" + output + ", compilerArgs=" + compilerArgs + "]";
	}

}
