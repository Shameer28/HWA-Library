package com.qa.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Library {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)	//AUTO INCREMENT
	private Integer libID;
	
	@Column
	private String name;
	
	
	
	@Override
	public String toString() {
		return "Library [libID= " + libID + ", name= " + name + "]";
	}

	//	CONSTRUCTOR
	public Library(String name) {
		super();
		this.name = name;
	}
	
	// CONSTRUCTOR
	public Library(Integer libID, String name) {
		super();
		this.libID = libID;
		this.name = name;
	}
	
	public Library() {
		//CONSTRUCTOR FOR C.R.U.D
	}
	
	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libID == null) ? 0 : libID.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Library other = (Library) obj;
		if (libID == null) {
			if (other.libID != null)
				return false;
		} else if (!libID.equals(other.libID))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
