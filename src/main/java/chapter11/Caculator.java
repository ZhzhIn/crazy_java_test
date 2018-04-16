package chapter11;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.border.Border;

class ButtonListener implements ActionListener{
	private TextArea textArea;
	public ButtonListener(TextArea result) {
		// TODO Auto-generated constructor stub
		this.textArea=result;
	}
	public TextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String pre=e.getActionCommand();
		String result =textArea.getText();
		if(Pattern.matches("\\d|.", pre)){
			if(!(pre.equals(0)&&result.equals(0))
					&&
					!(pre.endsWith("."))){
			result = result+e.getActionCommand();
			textArea.setText(result);
			}
		}
	}

	
}
public class Caculator {
	private Frame f = new Frame("计算器");
	//水平摆放组件的box
	String[] s1 = {"MC","MR","M+","M-","MS","<-","CE"
			,"C","±","√￣","7","8","9","/","%","4"
			,"5","6","*","1/x","1","2","3","-"};
	Button[] b1 = new Button[24];
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private TextArea result = new TextArea(4,100);
	public void init(){
		f.addWindowListener(new MyWindowListener());
		f.setLayout(gb);
		//窗口可拉伸f
		gbc.fill=GridBagConstraints.BOTH;
		//水平拉伸，垂直拉伸
		gbc.weightx=1;
		gbc.weighty=1;
		
		//添加textArea
		//当前作为该行最后一个按钮
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		
		gb.setConstraints(result, gbc);
		f.add(result);
		
		
		//一排五个按钮
		
		for(int i =0;i<s1.length;i++){
			//一排五个
			gbc.gridwidth=1;
			if(i%5==4){
				//当前是最后一个
				gbc.gridwidth=GridBagConstraints.REMAINDER;
			}
			b1[i]=new Button(s1[i]);
			b1[i].addActionListener(new ButtonListener(result));
			gb.setConstraints(b1[i], gbc);
			f.add(b1[i]);
		}
			
		//添加一个纵跨两格，横一格的按钮
		
		Button equal = new Button("=");
//		gbc.gridx=4;
		gbc.gridy=5;
		gbc.gridheight=2;
		
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		equal.addActionListener(new ButtonListener(result));
		gb.setConstraints(equal, gbc);
		f.add(equal);

		//添加一个横跨两格，竖一格的按钮
		gbc.gridheight=1;
		gbc.gridwidth=2;
		gbc.gridy=6;
		gbc.gridx=0;

		addButton(new Button("0"));
		gbc.gridwidth=1;
		gbc.gridx=2;
		addButton(new Button("."));
		gbc.gridx=3;
		addButton(new Button("+"));
		
		//f接着添加无数个button，放在box里面，再把box添加进f
		
		f.pack();
		f.setVisible(true);
	}
	private void addButton(Button button ){
//		button.addActionListener(new ButtonListener(result));
		gb.setConstraints(button, gbc);
		f.add(button);
		button.addActionListener(new ButtonListener(result));
	}
	public static void main(String[]args){
		Caculator ca =new Caculator();
		ca.init();
	}
}
class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}