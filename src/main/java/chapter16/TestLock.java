package chapter16;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
	private final ReentrantLock lock = new ReentrantLock();
	//可重入性，可嵌套加锁
	public void protectLock(){
		lock.lock();
		try{
			System.out.println("这里是需要保证线程安全的代码");
		}
		finally{
			lock.unlock();
		}
	}
}
