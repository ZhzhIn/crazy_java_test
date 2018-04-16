package chapter14;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {

	public static void processAnnotations(Object obj) {
		// TODO Auto-generated method stub
		try{
			Class cl = obj.getClass();
			for(Field f :cl.getDeclaredFields()){
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				if((a!=null) && (a instanceof AbstractButton)){
					Class listenerClazz = Class.forName(a.listener());
					ActionListener al = (ActionListener)listenerClazz.newInstance();
					AbstractButton ab = (AbstractButton)f.get(obj);
					ab.addActionListener(al);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
