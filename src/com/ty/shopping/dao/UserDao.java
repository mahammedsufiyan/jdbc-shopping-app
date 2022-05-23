package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.ty.shopping.dto.User;
import com.ty.shopping.util.AES;
import com.ty.shopping.util.ConnectionObject;
import static com.ty.shopping.util.AppConstants.SECRET_KYE;

public class UserDao {
	
	
	public User updateUser(int id, User user) {
		
		Connection connection = ConnectionObject.getConnection();
		String sql="UPDATE TABLE FROM user WHERE id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			User user1=user;
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			user1.setPassword(user.getPassword());
			user1.setMobile(user.getMobile());
			preparedStatement.execute();
			return user1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public int deletUser(int id) {
		Connection connection=ConnectionObject.getConnection();
		String sql="DELETE FROM user WHERE id=?";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//Validate user
	public User validationUser(String email, String password) {
		String sql= "Select * from user where email=? and password=?";
		Connection connection = ConnectionObject.getConnection();
	
		try {
			String enc=AES.encrypt(password, SECRET_KYE);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, enc);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setMobile(resultSet.getLong(5));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int saveUser(User user) {
		String sql="INSERT INTO user VALUES(?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			
			// encripting data
			String enc = AES.encrypt(user.getPassword(), SECRET_KYE);
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, enc);
			preparedStatement.setLong(5, user.getMobile());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}	
}
