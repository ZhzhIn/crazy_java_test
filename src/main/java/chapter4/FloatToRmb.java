package chapter4;

public class FloatToRmb {
	static String []bigDigit={"元","万","亿"};
	static String []staticDigit={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	static String zero="零";
	public static void main(String[] args) {
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(11.5));
		System.out.println(Math.round(11.6));
		System.out.println(Math.round(-11.4));
		System.out.println(Math.round(-11.5));
		System.out.println(Math.round(-11.6));
	}
	public static String getString(double l){
		long a=(long) Math.floor(l);
		long b=Math.round((l-a)*100);
		String inte=String.valueOf(a);
		String floate=String.valueOf(b);
		String str="";
		String[]intee=cutNum(inte);
		if(!((inte.length()==1)&&inte.equals("0"))){
			for(int i=0;i<intee.length;i++){
//			System.out.print(intee[i]);
			str=handleNum(intee[i])+bigDigit[i]+str;
			}
		}
		return str=str+handleFloat(floate);
	}
	
	public static String toChinese(String num){
		String result="";
		for(int i =0;i<num.length();i++){
			//对每一位进行遍历，每一位从0~9，分别赋值staticDigit[0]~[9]
			if(num.substring(i,i+1).matches("\\d")){
				int j =Integer.valueOf(num.substring(i,i+1));
				result=result+staticDigit[j];
			}else{
				result=result+num.substring(i,i+1);
			}
			
		}
		return result;
	}
	
	
	public static String handleFloat(String num){//11
		String a ="";
		String [] f={"角","分"};
//		System.out.println(num.length());
		if(num.length()!=0){
			for(int i =0;i<num.length();i++){
				if(!num.substring(i, i+1).equals("0")){
					a=a+num.substring(i,i+1)+f[i];
				}
			}
		}
		return a;
	}
	public static String[] cutNum(String num){
		int digit=getDigit(num.length());
		String []a=new String[digit];
		while(num.length()<4*digit){
			num="0"+num;
		}
		for(int i=0;i<digit;i++){
			//将num进行四位切割
			a[i]=num.substring((digit-i-1)*4,(digit-i)*4);//从后往前填充 
		}
		return a;
	}
	public static String handleNum(String num){
		String []smallDigit={"千","百","拾",""};
		String newNum="";
		for(int i=num.length();i>0;i--){//1010 i=1
            if(!num.substring(i-1,i).equals("0")){//给不等于0的位数加上单位
            	newNum=num.substring(i-1,i)+smallDigit[i-1]+newNum;
            }
            else if(
            		num.substring(i-1,i).equals("0")//当前位的数值为0，后面数值有，前面数值不全为0，补“零"
                    &&(newNum.length()!=0)
                    &&(notAllZero(num))
            		){
            	newNum=zero+newNum;
            }
            num=num.substring(0,i-1);//每个循环，缩短一下str的尾部
        }
		return newNum;
	}
	
	public static int getDigit(int length){
		int a =0;
		a=(int)Math.ceil((double)length/4);
		return a ;
	}
	
	public static boolean notAllZero(String str){
		boolean b = false;//默认全0
		while(str.length()>0){
			if(!(str.substring(str.length()-1, str.length()).equals("0"))){
				b=true;
				break;
			}
				str=str.substring(0,str.length()-1);
		}
		return b;
	}
}
