package com.av.sessionbean.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.av.sessionbean.Exceptions.DaoException;
import com.av.sessionbean.Models.User;

@Stateless
@LocalBean
public class JdbcUserDao implements UserDao {

	private Connection conn;
	
	@PostConstruct
	public void initialize() throws DaoException {
		try {
			this.conn = getConn();
		} catch (SQLException e) {
			 throw new DaoException("Can`t get connection", e);
		} 
	}
	
	@Override
	public boolean create(User t) throws DaoException {
		
		PreparedStatement prepState = null;
		
		try {
			String sql = "INSERT INTO user (nickname, name, rating) VALUES (?, ?, ?)";
			prepState = conn.prepareStatement(sql);
			prepState.setString(1, t.getNickname());
			prepState.setNString(2, t.getName());
			prepState.setLong(3, t.getRating());
			int countOfUpdLines = prepState.executeUpdate();
			
			if (countOfUpdLines > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			throw new DaoException("Can`t create User", e);
		} finally {
			
			try {
				prepState.close();
				prepState = null;
			} catch (SQLException e) {
				throw new DaoException("Can`t close prepared statement", e);
			}
		}
		
		return false;
	}

	@Override
	public List<User> getAll() throws DaoException {
		
		List<User> users = new ArrayList<User>();
	    Statement state = null;
		ResultSet resultSet = null;
		 
		try {
			String sql = "SELECT * FROM user";
			state = conn.createStatement();
			resultSet = state.executeQuery(sql);
			
			while(resultSet.next()) {
				long id = resultSet.getLong(1);
				String nickname = resultSet.getString(2);
				String name = resultSet.getString(3);
				long rating = resultSet.getLong(4);
				users.add(new User(id, nickname, name, rating));
			}
		} catch (SQLException e) {
			 throw new DaoException("Can`t get all users" ,e);
		} finally {
			try {
				resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close result set", e);
			}
			try {
				state.close();
				state = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close statement", e);
			}
		}
				
		return users;
	}

	@Override
	public User getById(long id) throws DaoException {
		
		User user = null;
	    PreparedStatement prepState = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT * FROM user WHERE id = ?";
			prepState = conn.prepareStatement(sql);
			prepState.setLong(1, id);
			resultSet = prepState.executeQuery();
			if (resultSet.next()) {
				String nickname = resultSet.getString(2);
				String name = resultSet.getString(3);
				long rating = resultSet.getLong(4);
				user = new User(id, nickname, name, rating);
			}
		} catch (SQLException e) {
			 throw new DaoException("Can`t get user by id " + id , e);
		} finally {
			try {
				resultSet.close();
				resultSet = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close result set", e);
			}
			try {
				prepState.close();
				prepState = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close prepared statement", e);
			}
		}
		
		return user;
	}

	@Override
	public boolean update(User t) throws DaoException {
		
		PreparedStatement prepState = null;
		
		try {
			String sql = "UPDATE user SET nickname = ?, name = ?, rating = ? WHERE id = ?";
			prepState = conn.prepareStatement(sql);
			prepState.setString(1, t.getNickname());
			prepState.setString(2, t.getName());
			prepState.setLong(3, t.getRating());
			prepState.setLong(4, t.getId());
			int countOfUpdLines = prepState.executeUpdate();

			if (countOfUpdLines > 0) {
				return true;
			}
		} catch (SQLException e) {
			 throw new DaoException("Can`t update user by id " + t.getId(), e);
		} finally {
			try {
				prepState.close();
				prepState = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close prepared statement", e);
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(long id) throws DaoException {
		
		PreparedStatement prepState = null;
		
		try {
			String sql = "DELETE FROM user WHERE id = ?";
			prepState = conn.prepareStatement(sql);
			prepState.setLong(1, id);
			int countOfUpdLines = prepState.executeUpdate();
			
			if (countOfUpdLines > 0) {
				return true;
			}
		} catch (SQLException e) {
			 throw new DaoException("Can`t delete user by id " + id, e);
		} finally {
			try {
				prepState.close();
				prepState = null;
			} catch (SQLException e) {
				 throw new DaoException("Can`t close prepared statement", e);
			}
		}
		
		return false;
	}
	
	@PreDestroy
	public void cleanup() throws DaoException {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			 throw new DaoException("Can`t close connection", e);
		}
	}
	
	public Connection getConn() throws SQLException {
		
		String url = "jdbc:mysql://mysql/sandbox?useSSL=false&user=root&password=root&serverTimezone=Europe/Moscow";
		return DriverManager.getConnection(url);
	}
	
}
