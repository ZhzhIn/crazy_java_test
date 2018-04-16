package chapter9;

import java.util.Locale;
import java.util.ResourceBundle;

//import net.sf.cglib.core.Local;

public class Hello {
	public static void main(String[]args){
/*		Locale[] localeList =Locale.getAvailableLocales();
		for(int i =0;i<localeList.length;i++){
			System.out.println(localeList[i].getDisplayCountry()+"="
		+localeList[i].getCountry()+" "+localeList[i].getDisplayLanguage()+
		"="+localeList[i].getLanguage());
		}*/
		
		/*System.out.println(myLocale.getDisplayCountry()+"="
		+myLocale.getCountry()+" "+myLocale.getDisplayLanguage()+
		"="+myLocale.getLanguage());*/
		Locale myLocale = Locale.getDefault();
		ResourceBundle bundle=ResourceBundle.getBundle("mess",myLocale);
		System.out.println(bundle.getString("hello"));
	}
}
