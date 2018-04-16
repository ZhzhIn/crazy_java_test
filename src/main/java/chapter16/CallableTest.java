package chapter16;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class RtnThread implements Callable<Character>{

	@Override
	public  Character call() throws Exception {
		// TODO Auto-generated method stub
		int i =0;
		for(;i<100;i++){
			System.out.println(Thread.currentThread().getName()
					+"的循环变量i的值 "+i);
		}
		return 'a';
	}
	
}
public class CallableTest {
	public static void main(String[]args){
		Callable<Character> rt = new RtnThread();
		FutureTask<Character>task =new FutureTask<Character>(rt);
		for(int i =0;i<100;i++){
			System.out.println(Thread.currentThread().getName()
					+"的循环变量i的值"+i);
			if(i==20){
				new Thread(task,"有返回值的线程").start();
			}
		}
		try{
			System.out.println("子线程的返回值"+task.get());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
