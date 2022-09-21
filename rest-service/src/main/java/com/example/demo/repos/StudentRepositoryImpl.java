package com.example.demo.repos;

import java.sql.*;
import java.util.*;

import com.example.demo.utils.ConnectionFactory;
import com.training.exceptions.ElementNotFoundException;
import com.training.ifaces.CrudRepository;
import com.training.model.Student;

public class StudentRepositoryImpl implements CrudRepository<Student> {

	
	//private static final Exception ElementNotFoundException = null;
	private Connection con;
	
	public StudentRepositoryImpl(Connection con) {
		super();
		this.con=con;
	}
	
	public StudentRepositoryImpl() {
		super();
		this.con=ConnectionFactory.getMySqlConnection();
	}

	@Override
	public boolean save(Student obj) {
		// TODO Auto-generated method stub
		String sql = "insert into lumen_student values(?,?,?)";
		int rowUpdated=0;
//		boolean update = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.getRollNumber());
			pstmt.setString(2, obj.getStudentName());
			pstmt.setDouble(3, obj.getMarks());
			rowUpdated = pstmt.executeUpdate();
//			if(rowUpdated==0) {
//				update=true;
//			}
//			else {
//				update=false;
//			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdated==1?true:false;
	}

	@Override
	public Collection<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> studList = new ArrayList<>();
		String sql = "select * from lumen_student";
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int rollNumber = rs.getInt("rollNumber");
				String studentName = rs.getString("studentName");
				double marks = rs.getDouble("marks");
				
				Student obj = new Student(rollNumber, studentName, marks);
				studList.add(obj);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studList;
	}
	@Override
	public boolean delete(Student obj) throws ElementNotFoundException {
		String sql = "delete from lumen_student where rollNumber=? ";
		
		// TODO FindByID and Throw Element Not Found
		
		int rowDeleted=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.getRollNumber());
			rowDeleted = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowDeleted==1?true:false;
	}
	@Override
	public Student findById(int key) throws ElementNotFoundException{
		// TODO Auto-generated method stub
		//List<Student> studList = new ArrayList<>();
		String sql = "select * from lumen_student where rollNumber=? ";
		Student obj = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int rollNumber = rs.getInt("rollNumber");
					String studentName = rs.getString("studentName");
					double marks = rs.getDouble("marks");
					obj = new Student(rollNumber, studentName, marks);
				}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(obj==null) {
			throw new ElementNotFoundException("Element not found","Element not found");
		}
		else {
			return obj;
		}
		
	}

	@Override
	public boolean deleteById(int key) throws ElementNotFoundException {
		// TODO Auto-generated method stub
		String sql = "delete from lumen_student where rollNumber=? ";
		int rowDeleted=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			rowDeleted = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowDeleted==1?true:false;
	}
	public boolean update(Student obj) {
		// TODO Auto-generated method stub
		String sql = "update lumen_student set studentName = 'haasitha' where rollNumber=?";
		int rowUpdated=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, obj.getRollNumber());
//			pstmt.setString(2, obj.getStudentName());
//			pstmt.setDouble(3, obj.getMarks());
			rowUpdated = pstmt.executeUpdate();
//			if(rowUpdated==0) {
//				update=true;
//			}
//			else {
//				update=false;
//			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowUpdated==1?true:false;
	}

}
