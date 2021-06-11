package com.qa.library.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Library {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //AUTO INCREMENT
	private Integer libID;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "library")
	@JsonIgnore
	private List<Books> book;
	

	//	GETTERS & SETTERS
	public Integer getLibID() {
		return libID;
	}

	public void setLibID(Integer libID) {
		this.libID = libID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		
	
}
