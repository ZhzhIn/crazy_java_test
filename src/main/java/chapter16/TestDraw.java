package chapter16;

public class TestDraw {
	public static void main(String[]args){
		Account acct = new Account("1234567",1000);
		new DrawThread("取钱甲",acct,800).start();
		new DepositThread("存钱甲",acct,800).start();
		new DepositThread("存钱乙",acct,800).start();
		new DepositThread("存钱丙",acct,800).start();
	}
}
