package chapter5.school;

import chapter5.people.Student;
import chapter5.people.Teacher;

public class School {
	private String name;
	private int classNo;
	private int gradeNo;
	private int teacherNo=0;
	private Teacher[]teacher;
	private Student[]student;
	private String[]subject;
	private int studentNo=0;
	private int subjectNo=0;
	
	public void setStudent(Student student) {
		this.student = new Student[this.getStudentNo()];
	}
	public void setSubject(String[] subject) {
		this.subject = subject;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length()<2||name.length()>20){
			System.out.println("校名长度应在2~20之间");
			return;
		}else{
			this.name = name;
		}
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		if(classNo<1||classNo>20){
			System.out.println("classNo应在1~20之间");
		}else{
			this.classNo = classNo;
		}
	}
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		if(gradeNo<1||gradeNo>20){
			System.out.println("gradeNo应在1~20之间");
		}else{
			this.gradeNo = gradeNo;
		}
	}
	public int getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(int teacherNo) {
		if(teacherNo<1||teacherNo>200){
			System.out.println("teacherNo应在1~200之间");
		}else{
			this.teacherNo = teacherNo;
			this.teacher=new Teacher[teacherNo];
		}
	}
	public int getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(int studentNo) {
		if(studentNo<1||studentNo>2000){
			System.out.println("studentNo应在1~2000之间");
		}else{
			this.studentNo = studentNo;
		}
	}
	public int getSubjectNo() {
		return subjectNo;
	}
	public void setSubject(int subjectNo) {
		this.subjectNo = subjectNo;
	}

	//构造方法
	public School(String name,int classNo,int gradeNo, int teacherNo,int studentNo,int subjectNo){
		setName(name);
		setClassNo(classNo);
		setGradeNo(gradeNo);
		setTeacherNo(teacherNo);
		setStudentNo(studentNo);
		setSubject(subjectNo);
	}
	//方法 输出学校的所有信息
	public void introduction() {
		// TODO Auto-generated method stub
		System.out.println("学校名称:"+getName()+",班级数量:"+getClassNo()+
				",年级数量:"+getGradeNo()+",老师数量:"+getTeacherNo()+
				",学生数量:"+getStudentNo()+",科目数量:"+getSubjectNo());
	}
	//教师增减
	public void addTeacher(Teacher tea){
		for(int i=0;i<getTeacherNo();i++){
			if(teacher[i]==null){
				teacher[i]=tea;
				break;
			}
		}
	}
	//显示老师的信息
	public void showTeacher(){
		System.out.println("当前的教师数量："+getTeacherNo());
		System.out.println("教师列表：");
		for(Teacher tea:teacher){
			if(tea!=null)
			System.out.println("教师姓名:"+tea.getName()+",执教科目："+tea.getSubject()+
					",执教年级以及班级:"+tea.getGradeNo()+"-"+tea.getClassNo());
		}
	}
	//学生增减
	public void addStudent(Student stu){
		for(int i=0;i<getStudentNo();i++){
			if(student[i]!=null){
				student[i]=stu;
			}
		}
	}
	//科目增减
	
}
