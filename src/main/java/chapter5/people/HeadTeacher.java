package chapter5.people;

/**
 * @author user
 *
 */
public class HeadTeacher extends Teacher {
	private int mainClassNo;
	public int getMainClassNo() {
		return mainClassNo;
	}
	public void setMainClassNo(int mainClassNo) {
		this.mainClassNo = mainClassNo;
	}
	public HeadTeacher(String name,int gradeNo,int classNo,String subject,int mainClassNo) {
		super(name,gradeNo,classNo,subject );
		// TODO Auto-generated constructor stub
		setMainClassNo(mainClassNo);
	}
	//除了继承父类的方法，还要管理班级
	//introduction
	//teach
	//管理班级
	
}
