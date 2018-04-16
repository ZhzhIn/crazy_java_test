package chapter16;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private final Lock lock = new ReentrantLock();
	private final Condition cond =lock.newCondition();
	private String accountNo;
	private double balance;
	private boolean flag = false;// 标识账户中是否已有存款

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}
	/*
	 * public void setBalance(double balance) { this.balance = balance; }
	 */

	public Account() {
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public int hashCode() {
		return accountNo.hashCode();
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
//取钱
	public void draw(double drawAmount) {
		lock.lock();
		try {
			if (!flag) {
				// 还没人存钱进去
				cond.wait();
			} else {
				if (balance >= drawAmount) {
					System.out.println(Thread.currentThread().getName() + "取钱成功，取出钞票：" + drawAmount);
					balance -= drawAmount;
					System.out.println("\t余额为：" + balance);
					flag = false;
					cond.signalAll();
				} else {
					System.out.println("取钱失败，余额不足");
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
	}
	//存钱
	public synchronized void deposit(double depositAmount){
		lock.lock();
		try{
			if(flag){
				//有人存钱啦
				cond.wait();
			}else{
				System.out.println(Thread.currentThread().getName()
						+"存款："+depositAmount);
				balance+=depositAmount;
				System.out.println("账户余额为："+balance);
				flag = true;
				cond.signalAll();
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
}
