package chapter14;

import java.lang.annotation.Annotation;

public class Test {
	@MyTag(name = "？？？",age=18)
	public void info() {
	}
	public static void main(String[]args) throws NoSuchMethodException, SecurityException, ClassNotFoundException{
		Annotation[]aArray = Class.forName("Test").getMethod("info").getAnnotations();
		for(Annotation an:aArray){
			System.out.println(an);
		}
	}
}
