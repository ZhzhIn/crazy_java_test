package chapter5.people;

/**
 * @author zhizhi.yin
 * @param name,gender,age
 * 
 */
public class People {
	private String name;
	private String gender;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length()>6||name.length()<2){
			System.out.println("姓名长度应在2~6的范围内");
			return;
		}else{
			this.name = name;
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		String[]g={"male","female","MALE","FEMALE","男","女"};
		for(String str:g){
			if(str.equals(gender)){
			this.gender=gender;	
			break;
		}
			System.out.println("性别字符不符合要求");
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>120||age<0){
			System.out.println("年龄范围应在0~120之间");
		}else{
			this.age = age;
		}
	}
	
	public People(String name ,String gender,int age ){
		//可以在构造器中，设置private的那些值
		setName(name);
		setAge(age);
		setGender(gender);
	}
	public People(String name){
		setName(name);
	}
	//自我介绍
	public void introduction(){
		System.out.println("name:"+getName()+",age:"+getAge()+",gender:"+getGender());
	}
}
