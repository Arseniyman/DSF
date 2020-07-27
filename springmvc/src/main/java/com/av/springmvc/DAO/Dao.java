package com.av.springmvc.DAO;

import java.util.ArrayList;

public interface Dao<T> {
	T getById(int id);
	ArrayList<T> getAll();
	boolean insert(T t);
	boolean update(T t);
	boolean delete(T t);
}