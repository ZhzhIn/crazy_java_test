package chapter5.test;

class People{
	private  String name;
	public void introduction(){
		System.out.println("name:"+name);
	}
	public People(String name){
		this.name=name;
	}
}
class HeadTeacher extends People{
	private String subject;
	public String getSubject(){
		return subject;
	}
	public HeadTeacher(String name,String subject){
		super(name);
		this.subject=subject;
	}
	public void teaching(){
		System.out.println("teaching "+getSubject());
	}
	public void introduction(){
		super.introduction();
		System.out.println("subject:"+getSubject());
	}
}
class School{
	//学校由 老师，学生，学科等组成
	//学校需要调用老师的teaching方法，学生的study方法等等
	private String name;
	HeadTeacher ht;
	public School(String name,HeadTeacher ht){
		this.name=name;
		this.ht=ht;
	}
	public void introduction(){
		System.out.println("学校名称："+name);
	}
	public void teaching(){
		ht.teaching();
	}
}
public class TestConbination {
	public static void main(String[]args){
		People p =new People("张三");
		HeadTeacher ht =new HeadTeacher("李四","物理");
		ht.introduction();
		ht.teaching();
		p.introduction();
		System.out.println("---------");
		School sch=new School("张家口学校",ht);
		sch.introduction();
		sch.teaching();
	}
}
