package com.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.domain.User;
@Transactional
@Repository
public class UserDAO {
    
    @Autowired
	private SessionFactory sessionfactory;
	

	
	public Boolean login(User userIns) {
		Session session = this.sessionfactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("email", userIns.getEmail())).add(Restrictions.eq("password", userIns.getPassword()));
		User user = (User) cr.uniqueResult();
		Boolean flag=false;
		if(user!=null) {
			/*if(user.getEmail()=="senior@gmail.com" && user.getPassword()=="senior") {
				flag=true;
			}
			else {
				flag=false;
			}*/
			flag=true;
		}
		else {
			flag=false;
		}
		return flag;
	}
	
}

