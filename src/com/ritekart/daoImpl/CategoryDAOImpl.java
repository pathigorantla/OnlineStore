package com.ritekart.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ritekart.dao.CategoryDAO;
import com.ritekart.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categoryList = session.createQuery("from Category").list();
		for (Category ct: categoryList) {
			logger.info("Category List::" + ct);
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category ct = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, category:" +ct);
		return ct;
	}

}
