package com.competition.game.webservices.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Languages")
public class Languages implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotEmpty(message = "Language name is required")
	private String name;

	@Column(name = "number")
	@NotEmpty(message = "Language number is required")
	private String number;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Languages(int id, @NotEmpty(message = "Language name is required") String name,
			@NotEmpty(message = "Language number is required") String number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}

	public Languages() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Languages [id=" + id + ", name=" + name + ", number=" + number + "]";
	}

}
