package chapter16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TestThreadr implements Runnable{
	public void run(){
		for(int i =0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+
					"的i的值为："+i);
		}
	}
}
public class ThreadPoolTest {
	public static void main(String[]args){
		//固定线程数6的线程池
		ExecutorService pool=Executors.newFixedThreadPool(6);
		pool.submit(new TestThreadr());
		pool.submit(new TestThreadr());
		pool.shutdown();
	}
}
