package chapter5.people;

import chapter5.school.School;

/**
 * @author user
 *
 */
public class Student extends People {
	private int classNo;
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	private int gradeNo;
	public Student(String name, String gender, int age ) {
		super(name, gender, age );
		// TODO Auto-generated constructor stub
	}
	public void studing(){
		System.out.println("在年级"+getGradeNo()+"班级"+getClassNo()+"学习课程");
	}
	//introduction
	//学习
}
