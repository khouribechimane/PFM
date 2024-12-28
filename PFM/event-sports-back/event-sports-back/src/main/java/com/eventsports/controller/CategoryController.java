package com.eventsports.controller;

import com.eventsports.dto.CategoryResponseDto;
import com.eventsports.dto.CommonApiResponse;
import com.eventsports.entity.Category;
import com.eventsports.resource.CategoryResource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/event/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
	
	@Autowired
	private CategoryResource categoryResource;
	
	@PostMapping("/add")
	@Operation(summary = "Api to add category")
	public ResponseEntity<CommonApiResponse> addCategory(@RequestBody Category category) {
		return categoryResource.addCategory(category);
	}
	
	@PutMapping("/update")
	@Operation(summary = "Api to update category")
	public ResponseEntity<CommonApiResponse> updateCategory(@RequestBody Category category) {
		return categoryResource.updateCategory(category);
	}
	
	@GetMapping("/fetch/all")
	@Operation(summary = "Api to fetch all category")
	public ResponseEntity<CategoryResponseDto> fetchAllCategory() {
		return categoryResource.fetchAllCategory();
	}
	
	@DeleteMapping("/delete")
	@Operation(summary = "Api to delete category all its events")
	public ResponseEntity<CommonApiResponse> deleteCategory(@RequestParam("categoryId") int categoryId) {
		return categoryResource.deleteCategory(categoryId);
	}

}
