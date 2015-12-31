package com.ritekart.dao;

import java.util.List;

import com.ritekart.model.Category;

public interface CategoryDAO {
	public List<Category> listCategories();
	public Category getCategoryById(int id);

}
