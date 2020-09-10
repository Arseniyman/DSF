package com.av.sessionbean.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.av.sessionbean.Dao.JdbcUserDao;
import com.av.sessionbean.Exceptions.DaoException;
import com.av.sessionbean.Models.User;
import java.io.Serializable;

@Named
@RequestScoped
public class UserController implements Serializable {
	
	private static final long serialVersionUID = -1507373694984101022L;
	
	@EJB
	private JdbcUserDao dao;
	private User user = new User();
	
	
//	public void setDao(JdbcUserDao dao) {
//		this.dao = dao;
//	}
	
	public String createUser() {
		try {
			dao.create(user);
			this.user = new User();
		} catch (DaoException e) {
			 System.out.println(e.getMessage());
		}
		
		return "index.xhtml";
	}
	
	public User getUser() {
		return user;
	}
	
	public List<User> getUsers() {
		try {
			return dao.getAll();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
		
		List<User> retUsers = new ArrayList<User>();
		retUsers.add(new User("Nick", "Nikolson Bor", 32));
		
		return retUsers;
	}
	
	
	public void getUserById() {
		try {
			user = dao.getById(user.getId());
		} catch (DaoException e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void editUser() {
		try {
			dao.update(user);
		} catch (DaoException e) {
			 System.out.println(e.getMessage());
		}
	}
	
	public void deleteUser(long id) {
		try {
			dao.delete(id);
		} catch (DaoException e) {
			System.out.println(e.getMessage());
		}
	}
}