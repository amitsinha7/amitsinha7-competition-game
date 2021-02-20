package com.competition.game.webservices.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "taskStatus", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "language_number", "Nick_Name", "preLoadedTaskId" }) })
public class TaskStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int taskStatusId;

	@ManyToOne
	@JoinColumn(name = "language_number")
	private Language language;

	@ManyToOne
	@JoinColumn(name = "Nick_Name")
	private Player player;

	@ManyToOne
	@JoinColumn(name = "preLoadedTaskId")
	private PreLoadedTask preLoadedTask;

	@Version
	@Column(name = "UPDATE_TIMESTAMP")
	private Calendar updateMadified;

	@Column(name = "CREATION_TIMESTAMP", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar dateCreated;

	public TaskStatus(int taskStatusId, Language language, Player player, PreLoadedTask preLoadedTask,
			Calendar updateMadified, Calendar dateCreated) {
		super();
		this.taskStatusId = taskStatusId;
		this.language = language;
		this.player = player;
		this.preLoadedTask = preLoadedTask;
		this.updateMadified = updateMadified;
		this.dateCreated = dateCreated;
	}

	public TaskStatus() {
		super();
	}

	public TaskStatus(int taskStatusId, Language language, Player player, PreLoadedTask preLoadedTask) {
		super();
		this.taskStatusId = taskStatusId;
		this.language = language;
		this.player = player;
		this.preLoadedTask = preLoadedTask;
	}

	public int getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
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

	public PreLoadedTask getPreLoadedTask() {
		return preLoadedTask;
	}

	public void setPreLoadedTask(PreLoadedTask preLoadedTask) {
		this.preLoadedTask = preLoadedTask;
	}

	public Calendar getUpdateMadified() {
		return updateMadified;
	}

	public void setUpdateMadified(Calendar updateMadified) {
		this.updateMadified = updateMadified;
	}

	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "TaskStatus [taskStatusId=" + taskStatusId + ", language=" + language + ", player=" + player
				+ ", preLoadedTask=" + preLoadedTask + ", updateMadified=" + updateMadified + ", dateCreated="
				+ dateCreated + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((preLoadedTask == null) ? 0 : preLoadedTask.hashCode());
		result = prime * result + taskStatusId;
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
		TaskStatus other = (TaskStatus) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (preLoadedTask == null) {
			if (other.preLoadedTask != null)
				return false;
		} else if (!preLoadedTask.equals(other.preLoadedTask))
			return false;
		if (taskStatusId != other.taskStatusId)
			return false;
		return true;
	}

}
