package chapter9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
	public static void main(String[]args){
/*		String regex="a*b";
		Pattern p=Pattern.compile(regex);
		Matcher m = p.matcher("b");
		System.out.println(m.matches());
		System.out.println(Pattern.matches(regex, "aaab"));*/
		
/*		String a ="&%*";
		String b="q12";
		String newStr ="";
		for(int i =0;i<a.length();i++){
			for(int j =0;j<b.length();j++){
				newStr=newStr+a.substring(i, i+1)+b.substring(j, j+1);
			}
		}*/
		String newStr="2,2";
		Pattern p1=Pattern.compile("^\\d\\d?,\\d\\d?$");
//		Pattern p1=Pattern.compile("^\d\d?,\d\d?$");
		//+代表前面的表达式可以出现1次或多次
		//贪婪模式，除非另有表示，就一直匹配下去；	
		//如果加上？,是勉强模式，匹配最少字符。
		Matcher m1 =p1.matcher(newStr);//查找数字和英文字符
//		m1=p1.matcher("a,2");
		System.out.println(m1.matches());
//		System.out.println(p1.matcher(newStr).matches());
		/*while(m1.find()){
			System.out.println(m1.group()+"子串起始位置："+m1.start()+"，子串结束位置："+m1.end());
			
		}
		System.out.println("-----------------------");
		int i =0;
		while(m1.find(i)){
			//group 返回上次于pattren匹配的子串
			System.out.println(m1.group()+"\t");
			i++;
		}*/
		
/*		//匹配所有单词字符，包括0~9，26个英文字母和下划线；
		//\w
		//非单词字符 \w
		String a ="&%*";
		String b="qwe123";
		String newStr ="";
		for(int i =0;i<a.length();i++){
			for(int j =0;j<b.length();j++){
				newStr=newStr+a.substring(i, i+1)+b.substring(j, j+1);
			}
		}
		System.out.println(newStr);
		
		//筛选&%*,*是正则表达式的一个字符，要用的时候就要加\\
		String str = "";
		regex="\\W";//匹配任一
		
		str=newStr.replaceAll(regex, "");
		System.out.println(str);
		//筛选qwe123
*/		
	}
}
