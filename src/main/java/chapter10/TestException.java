package chapter10;

public class TestException extends Exception {
	public TestException(){}
	public TestException(String msg){
		super(msg);
	}
	/*public TestException(Throwable t){
		super(t);
	}*/
}
