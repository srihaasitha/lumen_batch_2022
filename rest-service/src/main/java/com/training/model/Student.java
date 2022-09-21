package com.training.model;

public class Student {

	
	private int rollNumber;
	private String studentName;
	private double marks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNumber, String studentName, double marks) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.marks = marks;
	}
	/**
	 * @return the rollNumber
	 */
	public int getRollNumber() {
		return rollNumber;
	}
	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the marks
	 */
	public double getMarks() {
		return marks;
	}
	/**
	 * @param marks the marks to set
	 */
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return rollNumber + "," + studentName + "," + marks ;
	}

}
