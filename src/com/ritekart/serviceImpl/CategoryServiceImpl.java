package com.ritekart.serviceImpl;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ritekart.dao.CategoryDAO;
import com.ritekart.daoImpl.CategoryDAOImpl;
import com.ritekart.model.Category;
import com.ritekart.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	private CategoryDAO categoryDAO;
	int randomNum;
	public CategoryServiceImpl() {
		Random randomGenerator = new Random();
        randomNum = randomGenerator.nextInt(100);
        logger.info("random number:" + String.valueOf(randomNum));
	}
	public void setCategoryDAO(CategoryDAO categoryDAO){
		this.categoryDAO = categoryDAO;
	}
	@Override
	@Transactional
	public List<Category> listCategory() {
		return this.categoryDAO.listCategories();
	}

	@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

}
