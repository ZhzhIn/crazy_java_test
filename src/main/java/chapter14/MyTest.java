package chapter14;

public class MyTest {
	@Testable
	public static void m1(){}
	public static void m2(){}
	@Testable
	public static void m3(){
		//抛出运行异常
		throw new RuntimeException("Boom");
	}
	public static void m4(){}
	@Testable
	public static void m5(){}
	public static void m6(){}
	@Testable
	public static void m7(){
		throw new RuntimeException("Crash");
	}
	public static void m8(){}
}
