package chapter16;

public class DaemonThread extends Thread{
	public void run(){
		for(int i =0;i<1000;i++){
			System.out.println(getName()+" "+i);
		}
	}
	public static void main(String[]args){
		DaemonThread t = new DaemonThread();
		t.setDaemon(true);
		t.start();
		for(int i =0;i<10;i++){
			System.out.println(Thread.currentThread().getName()
					+" "+i);
		}
	}
}
