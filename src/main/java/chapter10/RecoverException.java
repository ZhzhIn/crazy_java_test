package chapter10;

public class RecoverException {
	private double initPrice=30.0;
	
	public void bid(String bidPrice) throws TestException{
		double d = 0.0;
		try{
			d=Double.parseDouble(bidPrice);
		}catch(Exception e ){
//			e.printStackTrace();
			throw new TestException("竞拍价必须是数值");
		}
		if(initPrice>d){
			throw new TestException("竞拍价必须比起拍价大");
		}
	}
	public static void main(String[]args) throws TestException{
/*		RecoverException re = new RecoverException();
		try {
			re.bid("2");
		} catch (TestException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
		try{
		  int s = 10/0;
		}catch(Exception e){
			throw new TestException("出现异常");
		}
		
	}
}
