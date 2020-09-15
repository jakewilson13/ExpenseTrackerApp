package com.tts2.expensetracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category")
public class Category {
	
		@Id
		private Long id;
		@NonNull
		//Travel, Grocery, etc (name of expense)
		private String name;
		
		//getters and setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		//toString
		@Override
		public String toString() {
			return "Category [id=" + id + ", name=" + name + "]";
		}
		
		
}
