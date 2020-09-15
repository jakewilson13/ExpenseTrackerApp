package com.tts2.expensetracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts2.expensetracker.model.Category;
import com.tts2.expensetracker.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	//private field to our category repository
		private CategoryRepository categoryRepository;
		
		public CategoryController(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
		}
		
		//method to get all the categories
		@GetMapping("/categories")
	Collection <Category> categories() {
			return categoryRepository.findAll();
			//select * (all) from categories
		}
		
		//{id} is how you pass a variable
		@GetMapping("/category/{id}")
		//@PathVariable because it's apart of the path in our getmapping method
		ResponseEntity<?> getCategory(@PathVariable Long id) {
			//going to return the category and it's optional because it might return nothing. the ID might not be vaild
			Optional<Category> category = categoryRepository.findById(id);
			
			return category.map(response -> ResponseEntity.ok().body(response))
					.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		}
		
		//responseentity adds an http status code
		@PostMapping("/category")
		ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException {
			Category result=categoryRepository.save(category);
			//insert into table...(sql)
			return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
		}
		
		//method to edit a category
		@PutMapping("/category/{id}")
		ResponseEntity<Category> updateCategory(@Validated @RequestBody Category category) {
			Category result = categoryRepository.save(category);
			return ResponseEntity.ok().body(result);
		}
		
		@DeleteMapping("/category/{id}")
		ResponseEntity<?> deleteCategory(@PathVariable Long id) {
			categoryRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
}
