package chapter14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AnnotationTest {
	private JFrame mainWin= new JFrame("使用注释绑定事件监听器");
	@ActionListenerFor(listener="chapter14.OkListener")
	private JButton ok = new JButton("确定");
	@ActionListenerFor(listener= "chapter14.CancelListener")
	private JButton cancel = new JButton("取消");
	public void init(){
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[]args){
		new AnnotationTest().init();
	}
	class OkListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JOptionPane.showMessageDialog(null, "单机了确认按钮");
		}
	}
	class CancelListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			JOptionPane.showMessageDialog(null, "单机了取消按钮");
		}
	}
}
