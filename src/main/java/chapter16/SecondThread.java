package chapter16;

public class SecondThread implements Runnable{
	private int i ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;i<100;i++)
		{
			System.out.println(Thread.currentThread()+
					" "+i);
		}
	}
	public static void main(String[]args){
		for(int i =0;i<100;i++){
			System.out.println(Thread.currentThread().getName()+
					" "+i);
			if(i ==20){
				SecondThread st = new SecondThread();
				new Thread(st,"新县城1").start();
				new Thread(st,"新县城2").start();
			}
		}
	}

}