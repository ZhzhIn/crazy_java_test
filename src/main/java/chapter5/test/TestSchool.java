package chapter5.test;

import chapter5.people.HeadTeacher;
import chapter5.people.Teacher;
import chapter5.school.School;

public class TestSchool {
	public static void main(String[]args){
		int classNo=5;
		int gradeNo=3;
		int teacherNo=20;
		int studentNo=200;
		int subjectNo=10;
				
		School school=new School("测试学校", classNo, gradeNo,teacherNo,studentNo,subjectNo);
		school.introduction();
		Teacher teaA=new Teacher("张三", 1, 2, "物理");
		HeadTeacher teaB=new HeadTeacher("李四",1,3,"数学",3);
		school.addTeacher(teaA);
		school.addTeacher(teaB);
		school.showTeacher();
		//给学校增加老师
		
		//查看学校老师的资料
		
	}
}
