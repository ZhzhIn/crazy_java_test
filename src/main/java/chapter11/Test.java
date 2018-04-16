package chapter11;
import java.awt.BorderLayout; 
import java.awt.Button; 
import java.awt.Frame; 
import java.awt.GridBagConstraints; 
import java.awt.GridBagLayout; 
import java.awt.Insets; 
import java.awt.Panel; 
import java.awt.TextField; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
public class Test{ 
Frame f = new Frame("Colculator"); 
TextField tf = new TextField(30); 
Panel keyboard = new Panel(); 
GridBagLayout gb = new GridBagLayout(); 
GridBagConstraints gbc = new GridBagConstraints(); 
boolean ifOperation = false; // 是否在运算状态 
double d1 = 0d; // 第一个参数 
double d2 = 0d; // 第二个参数 
String operation =""; // 运算符 
private void init() { 
keyboard.setLayout(gb); 
gbc.fill = GridBagConstraints.BOTH; 
gbc.insets = new Insets(4, 4, 4, 4); 
gbc.weightx = 1; 
addNumbers(1); // 添加第一行数字按钮 
commonOperation("+"); // 添加加号 
// 换行 
gbc.gridwidth = GridBagConstraints.REMAINDER; 
addClearBtn("C"); 
gbc.weightx = 1; 
gbc.gridwidth = 1; 
addNumbers(2); 
commonOperation("-"); 
gbc.gridwidth = GridBagConstraints.REMAINDER; 
addDeleteBtn("<"); 
gbc.weightx = 1; 
gbc.gridwidth = 1; 
addNumbers(3); 
commonOperation("*"); 
//修正后代码:感谢 @CCNU 的解答 
gbc.gridx=4; 
gbc.gridy=2; 
gbc.gridheight = 2; 
gbc.weighty = 1; 
gbc.gridwidth = GridBagConstraints.REMAINDER; 
addEqualsBtn("="); 
gbc.gridx=0; 
gbc.gridy=3; 
gbc.gridwidth = 2; 
gbc.gridheight = 1; 
gbc.weightx = 1; 
gbc.weighty = 1; 
addZeroBtn("0"); 
gbc.gridx=2; 
gbc.gridy=3; 
gbc.gridwidth = 1; 
addDotBtn("."); 
gbc.gridx=3; 
gbc.gridy=3; 
commonOperation("/"); 
f.setLayout(new BorderLayout()); 
f.add(tf, BorderLayout.NORTH); 
f.add(keyboard); 
f.addWindowListener(new CloseListener()); 
f.pack(); 
f.setVisible(true); 
} 
/** 
* 添加点按钮 
* 
* @param string 
*/ 
private void addDotBtn(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
String val = tf.getText(); 
if (val.equals("")) { 
tf.setText("0."); 
} else if (val.indexOf(".") < 0) { 
tf.setText(tf.getText() + btn.getLabel()); 
} 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 添加数字0按钮 
* 
* @param string 
*/ 
private void addZeroBtn(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
String val = tf.getText(); 
if (val.startsWith("0.") || val.isEmpty()) { 
tf.setText(tf.getText() + btn.getLabel()); 
} 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 运算通用方法 
* 
* @param string 
*/ 
private void commonOperation(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
ifOperation = true; 
operation = e.getActionCommand(); 
String val = tf.getText(); 
if (!val.equals("")) { 
d1 = Double.valueOf(val); 
} 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 添加等号按钮 
* 
* @param string 
*/ 
private void addEqualsBtn(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
ifOperation = true; 
String val = tf.getText(); 
if (!val.equals("")) { 
d2 = Double.valueOf(val); 
if (!operation.equals("")) { 
Double d = 0d; 
switch (operation.charAt(0)) { 
case '+': 
d = d1 + d2; 
break; 
case '-': 
d = d1 - d2; 
break; 
case '*': 
d = d1 * d2; 
break; 
case '/': 
d = d1 / d2; 
break; 
} 
tf.setText(d +""); 
} else { 
tf.setText(d2 +""); 
} 
} 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 添加清空按钮 
* 
* @param string 
*/ 
private void addClearBtn(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
tf.setText(""); // 清空内容 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 添加删除按钮 
* 
* @param string 
*/ 
private void addDeleteBtn(String string) { 
final Button btn = new Button(string); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
String val = tf.getText(); 
if (!val.equals("")) { 
tf.setText(val.substring(0, val.length() - 1)); 
} 
} 
}); 
keyboard.add(btn); 
} 
/** 
* 添加数字按钮 
* 
* @param row 
*/ 
private void addNumbers(int row) { 
for (int i = 1; i <= 3; i++) { 
keyboard.add(getNumberBtn((row - 1) * 3 + i +"")); 
} 
} 
/** 
* 获取数字按钮 
* 
* @param number 
* @return 
*/ 
private Button getNumberBtn(String number) { 
final Button btn = new Button(number); 
gb.setConstraints(btn, gbc); 
btn.addActionListener(new ActionListener() { 
@Override 
public void actionPerformed(ActionEvent e) { 
if (ifOperation) { 
tf.setText(""); 
ifOperation = false; 
} 
tf.setText(tf.getText() + btn.getLabel()); 
} 
}); 
return btn; 
} 
class CloseListener extends WindowAdapter { 
@Override 
public void windowClosing(WindowEvent e) { 
System.exit(0); 
} 
} 
public static void main(String[] args) { 
new Test().init(); 
} 
}