package com.av.sessionbean.Dao;

import java.util.List;

import com.av.sessionbean.Exceptions.DaoException;
import com.av.sessionbean.Models.User;

public interface UserDao extends Dao<User>{
	@Override
	boolean create(User user) throws DaoException;
	@Override
	List<User> getAll() throws DaoException;
	@Override
	User getById(long id) throws DaoException;
	@Override
	boolean update(User user) throws DaoException;
	@Override
	boolean delete(long id) throws DaoException;
}