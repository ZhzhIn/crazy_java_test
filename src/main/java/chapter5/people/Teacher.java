package chapter5.people;

import chapter5.school.School;

/**
 * @author Zhizhi.Yin
 *
 */
public class Teacher extends People {
//	private School school;
	private String subject;
	private int classNo;//可以多个
	private int gradeNo;
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;                                                                                                                                                                             
	}
	public int  getClassNo() {
		return classNo;
	}
	public void setClassNo(int  classNo) {
		this.classNo = classNo;
	}
	/*public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}*/
	//子类的构造方法必须要继承父类的构造方法
	//子类的构造方法运行时，一定会先运行父类的构造方法
	public Teacher(String name, String gender, int age ,int gradeNo,int classNo,String subject) {
		super(name, gender, age );
		// TODO Auto-generated constructor stub
		//除此之外 还要赋值一些基本的资料
		setGradeNo(gradeNo);
		setClassNo(classNo);
		setSubject(subject);
	}
	public Teacher(String name ,int gradeNo,int classNo,String subject){
		super(name);
		setGradeNo(gradeNo);
		setClassNo(classNo);
		setSubject(subject);
	}
	//introduction,重写父类的introduction方法
	public void introduction(){
		super.introduction();//引用父类的introduction方法
		System.out.println("teacher自己的介绍");
	}
	public void teaching(){
		//
		System.out.println("在班级:"+getClassNo()+",年级:"+getGradeNo()+"执教"+getSubject()+"课程");
	}
}
