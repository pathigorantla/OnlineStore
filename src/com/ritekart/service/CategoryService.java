package com.ritekart.service;

import java.util.List;

import com.ritekart.model.Category;

public interface CategoryService {
	public List<Category> listCategory();
	public Category getCategoryById(int id);
}
