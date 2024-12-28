package com.eventsports.service;

import com.eventsports.dao.CategoryDao;
import com.eventsports.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category addCategory(Category category) {
		return this.categoryDao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryDao.save(category);
	}

	@Override
	public Category getCategoryById(int categoryId) {

		Optional<Category> optionalCategory = this.categoryDao.findById(categoryId);

		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}

	}

	@Override
	public List<Category> getCategoriesByStatusIn(List<String> status) {
		return this.categoryDao.findByStatusIn(status);
	}

}
