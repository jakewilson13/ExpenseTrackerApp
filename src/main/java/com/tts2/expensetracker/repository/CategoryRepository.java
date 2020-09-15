package com.tts2.expensetracker.repository;

import com.tts2.expensetracker.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);
}
