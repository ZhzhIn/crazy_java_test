package testgroup.testartifact;

public class TestAccount {
	public static void main(String[]args)
	{
		String[][]a={{"1-","2-","3-"},{"4-","5-","6-"},{"7-","8-","9_"}};
		System.out.println("a.toString:"+a.toString()+"\n,a[0]:"+a[0].toString()+"\n,a[1]"+a[1].toString()+"\n,a[0,0]:"
		+a[0][0].toString()+"\n,a[1,1]:"+a[1][1].toString()+"\n,a[2][2]"+a[2][2].toString());
	}
}
