package chapter3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrinterCircle {
	public static int getInput(){
		int a =-1;
		while(true){
		Scanner scan = new Scanner(System.in);
		if(scan.hasNextInt()){
			 a=scan.nextInt();
			if (a>0){
			System.out.println("输入的数据为：" + a);
			break;}
			else{
				System.out.println("请重新输入");
			}
		}else{
			System.out.println("请重新输入");
		}
		}
		return a ;
	}
	public static void paint(int r){
		for(int i = r;i>=r*(-1);i--){
			int a=r-(int)Math.sqrt((r*r)-(i*i)); //*左侧的间隔数
			int b=r-a;//两个*之间的间隔数
			String str=space(a)+"*"+space(b*2)+"*";
			System.out.println(str);
		}
	}
	public static String space(int x){
		String str = "";
		for(int i=0;i<x;i++){
			str = str+"--";
		}
		return str;
	}
	
	public static void main(String []args){
		//int r = getInput();
		//paint(r);
		paint(6);
	}
}
