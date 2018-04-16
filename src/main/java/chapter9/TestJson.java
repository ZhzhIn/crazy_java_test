package chapter9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestJson {
	
	public void splitStr(String str){
		String regx="\\w+:'\\w+'";
		Pattern p = Pattern.compile(regx);
		Matcher matcher = p.matcher(str);
		
		while(matcher.find()){
			
			System.out.println(matcher.group());
		}
	}
	public static void main(String[]args){
		 String str="{c1:'cc',b2:[{a2:'aa',d2:'dd'},{b3:'cc'},d4:'dd'],d5:'dd',f:{16:'12',27:'22',38:'333'}}";
		TestJson tj =new TestJson();
		tj.splitStr(str);
	}
}
/*		String[] str1=str.split(",");
for(String s :str1){
	while(s.contains("{")||s.contains("}")){
		if(s.contains("{")){
			s=s.substring(s.lastIndexOf('{')+1, s.length());
			continue;
		}else if(s.contains("}")){
			s=s.substring(0,s.indexOf('}'));
		}
	}
	System.out.println(s);
}*/