package chapter16;
class Accountt{
	private ThreadLocal<String>name=new ThreadLocal<String>();
	public Accountt(String str){
		this.name.set(str);
		System.out.println("-----"+this.name.get());
	}
	public String getName(){
		return name.get();
	}
	public void setName(String str){
		this.name.set(str);
	}
}
class MyTest extends Thread{
	private Accountt accountt;
	public MyTest(Accountt accountt ,String name ){
		super(name);
		this.accountt=accountt;
	}
	public void run(){
		for(int i =0;i<10;i++){
			if(i==6){
				accountt.setName(getName());
			}
			System.out.println(accountt.getName()+"账户的i值"+i);
		}
	}
}
public class ThreadLocalTest {
	public static void main(String[]args ){
		Accountt at =new Accountt("初始名");
		new MyTest(at,"线程甲").start();
		new MyTest(at,"线程乙").start();
	}
}
