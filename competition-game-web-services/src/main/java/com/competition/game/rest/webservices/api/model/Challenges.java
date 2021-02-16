package com.competition.game.rest.webservices.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Challenges")
public class Challenges implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	@NotEmpty(message = "Challenge Description is required")
	private String description;

	@Column(name = "challenge_type")
	@NotEmpty(message = "Challenge Name  is required")
	private String challengeType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChallengeType() {
		return challengeType;
	}

	public void setChallengeType(String challengeType) {
		this.challengeType = challengeType;
	}

	public Challenges(int id, @NotEmpty(message = "Challenge Description is required") String description,
			@NotEmpty(message = "Challenge Name  is required") String challengeType) {
		this.id = id;
		this.description = description;
		this.challengeType = challengeType;
	}

	@Override
	public String toString() {
		return "Challenges [id=" + id + ", description=" + description + ", challengeType=" + challengeType + "]";
	}

	public Challenges() {

	}

}
