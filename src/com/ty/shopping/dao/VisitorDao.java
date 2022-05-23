package com.ty.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import javax.print.attribute.standard.PresentationDirection;

import com.ty.shopping.dto.Visitor;
import com.ty.shopping.util.ConnectionObject;

public class VisitorDao {
	
	// Save visitor
	public int saveVisitor(Visitor visit) {
		
		Connection connection = ConnectionObject.getConnection();
		
		String sql="INSERT INTO visitor VALUES (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,visit.getId() );
			preparedStatement.setString(2, visit.getName());
			preparedStatement.setLong(3, visit.getPhone());
			preparedStatement.setInt(4, visit.getAge());
			preparedStatement.setString(5, visit.getGender());
			preparedStatement.setString(6, visit.getDob()+"");
			preparedStatement.setString(7, visit.getVisitedTime()+"");
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
//	public  int validateUser(int id, Visitor visit) {
//		Connection connection=ConnectionObject.getConnection();
//		
//		String sql= "SELECT * FORM USER WHERE id=?";
//		
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, id);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public int updateUser(int id, Visitor vist) {
		Connection connection = ConnectionObject.getConnection();
		
		String sql="UPDATE FROM visitor WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}  

	}
}
