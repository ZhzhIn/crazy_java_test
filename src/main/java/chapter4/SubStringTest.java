package chapter4;

public class SubStringTest {
	public static void main(String[]args){
		String str="中国国国abcb";
		System.out.println(str.substring(1, 8));
		System.out.println(test(str,1,8));
	}
	public static String test(String str ,int a,int b){
		for(int i=a;i<b;i++){
			if(str.charAt(i)<0||str.charAt(i)>127){
				b=b-1;
			}
		}
		return str.substring(a,b);
	}
}
