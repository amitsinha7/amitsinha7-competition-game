package com.competition.game.webservices.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Player")
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	@NotEmpty(message = "Player Name is required")
	private String name;

	@Id
	@Column(name = "Nick_Name")
	@NotEmpty(message = "Player Nick Name is required")
	private String nickName;

	@Column(name = "Email_Id")
	@NotEmpty(message = "Player Email Id is required")
	private String emailId;

	@OneToMany(mappedBy = "player")
	private Set<Task> tasks = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Player(@NotEmpty(message = "Player Name is required") String name,
			@NotEmpty(message = "Player Nick Name is required") String nickName,
			@NotEmpty(message = "Player Email Id is required") String emailId, Set<Task> tasks,
			Set<Language> languages) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.emailId = emailId;
		this.tasks = tasks;
	}

	public Player(@NotEmpty(message = "Player Name is required") String name,
			@NotEmpty(message = "Player Nick Name is required") String nickName,
			@NotEmpty(message = "Player Email Id is required") String emailId) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.emailId = emailId;
	}

	public Player() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
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
		Player other = (Player) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", nickName=" + nickName + ", emailId=" + emailId + ", tasks=" + tasks + "]";
	}

}
