package com.tts2.expensetracker.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="expense")
public class Expense {
	
	@Id
	private Long id;
	
	//Instant is used to record time stamps
	private Instant expensedate;
	//description
	private String descript;
	
	private String location;
	
	//many expenses go to one category
	@ManyToOne
	private Category category;
	
	//json ignore meansyou don't wanna include that in the respose
	//because it returns user information
	@JsonIgnore
	//many expenses go to one user
	@ManyToOne
	private User user;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
	this.id = id;
	}

	public Instant getExpensedate() {
		return expensedate;
	}

	public void setExpensedate(Instant expensedate) {
		this.expensedate = expensedate;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expensedate=" + expensedate + ", descript=" + descript + ", location="
				+ location + ", category=" + category + ", user=" + user + "]";
	}
	
	
}
