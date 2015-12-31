package com.ritekart.daoImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ritekart.dao.LoginDAO;
import com.ritekart.model.AppUser;
import com.ritekart.model.UserRole;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
    
  /**
   * Finds the user which has a matching user name
   * @param userName
   * @return
   */
	@SuppressWarnings("unchecked")
	@Override
	public Object findUserByUserName(String userName) {
		Session session = sessionFactory.getCurrentSession();
		
		List<AppUser> users = new ArrayList<AppUser>();
		Set<UserRole> userRoles = new HashSet<UserRole>(0);
		
		String hql = "from AppUser U WHERE U.userName = :userName";
		Query query = (Query) session.createQuery(hql).setParameter("userName", userName);
		users =  query.list();
		
		AppUser user = null;
		if(users.size() > 0) user = users.get(0);
		//Get the user roles
		
		hql = "from UserRole R WHERE R.userName = :userName";
		query = session.createQuery(hql).setParameter("userName", userName);
		userRoles = (Set<UserRole>) query.list();
		
		user.setUserRoles(userRoles);
		
		return user;
	}

}
