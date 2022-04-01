package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {
	private int id;
	private String firstName;
	private String lastName;
	public int getId() {
		return id;
	}
	
	public Actor(int id, String first_name, String last_name) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
	}



	@Override
	public String toString() {
		return "Actor [id=" + id + ", first_name=" + firstName + ", last_name=" + lastName + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return firstName;
	}
	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}
	public String getLast_name() {
		return lastName;
	}
	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

}
