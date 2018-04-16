package chapter14;

public @interface MyTag {
	String name() default "zhizhi";
	int age()default 27;
}
