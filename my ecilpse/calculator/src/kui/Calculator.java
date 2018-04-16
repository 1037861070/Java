package kui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame{

static Calculator f=new Calculator();
static JPanel p1=new JPanel();
static JPanel p2=new JPanel();
static JTextField t=new JTextField("0",20);
static JButton b[]=new JButton[20];
static StringBuffer str=new StringBuffer();
static String name[]={"C","√","X^","+","7","8","9","-","4","5","6","*","1","2"
		 ,"3","/","0",".","%","="};
static double x,y;
static int z;

public static void main(String[] args) {   //主函数
		// TODO 自动生成的方法存根
f.setTitle("计算器！");
f.setLayout(null);
f.setBounds(20, 20, 280, 340);
f.setLocationRelativeTo(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //设置关闭动作

 p1.setBounds(20, 20, 233, 40);               
 t.setBackground(Color.yellow);               //设置输出框颜色
 t.setHorizontalAlignment(JTextField.RIGHT);  //是数字居右
 
 t.setEditable(false); //把输出显示框定义为不可写
 p1.add(t);
 f.add(p1);
 p2.setBounds(25, 60, 220, 230);
 p2.setLayout(new GridLayout(5,4,4,4));
 
 for(int i=0;i<name.length;i++){
	 b[i]=new JButton(name[i]);
	 b[i].addActionListener(f.new Listener());
	 b[i].setBackground(Color.lightGray);
	 p2.add(b[i]);
 }
 f.add(p2);

 f.setVisible(true);
	}
	
class Listener implements ActionListener {    //事件发生机制
	public void actionPerformed(ActionEvent e) {
	try{
		if (e.getSource() == b[16])// 如果选择的是"0"这个数字键
		{
		if (t.getText().trim().equals("0"))// 如果显示屏显示的为零不做操作
		{

		} else {
			str.append(e.getActionCommand());
			t.setText(str.toString());
			y = Double.parseDouble(t.getText().trim());
			}
		}	
		else if(e.getSource()==b[0]) //清零操作
		{
			t.setText("0");
			str.setLength(0);    //清除缓存区字符串
			}
		else if(e.getSource()==b[3])  //加法运算		
		{
			x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=1;
			}
		else if(e.getSource()==b[7])  //减法运算和负号操作
		{
		    if(t.getText().trim().equals("0"))  //输出负号操作
				{
					str.append(b[7].getText());
					t.setText(str.toString());
				}
				else{                          //减法运算
				x=Double.parseDouble(t.getText().trim());
				str.setLength(0);
				z=2;}
			}
		else if(e.getSource()==b[11])  //乘法运算
		{
			x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=3;
			}
		else if(e.getSource()==b[15])   //除法运算
		{
		    x=Double.parseDouble(t.getText().trim());
		    str.setLength(0);
		    z=4;
			}
		else if(e.getSource()==b[2])   //n次方
		{
		    x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=5;
			}
		else if(e.getSource()==b[19])     //显示结果
		{		
			str.setLength(0);
			switch(z)
			
			{
			case 1:t.setText(""+(x+y));
				break;
			case 2:t.setText(""+(x-y));
				break;
			case 3:t.setText(""+(x*y));
				break;
			case 4:t.setText(""+(x/y));
				break;
			case 5:t.setText(""+(Math.pow(x, y)));
				break;
			case 6:t.setText(""+(x%y));
				}
			}
		else if(e.getSource()==b[18])
		{
			 x=Double.parseDouble(t.getText().trim());
			 str.setLength(0);
			 z=6;
		}
		else if(e.getSource()==b[1]) //开方操作
			{  	
				x=Double.parseDouble(t.getText().trim());
				if(x<0)
				t.setText("负数没有平方根！");
				else
				t.setText("" + Math.sqrt(x));
				str.setLength(0);        
			}
		else if(e.getSource()==b[17])
			{
				if (t.getText().trim().indexOf('.') != -1)// 判断字符串中是否已经包含了小数点
				{}   //不作任何操作
				else{                         //出示显示为0
					if(t.getText().trim().equals("0")){
						str.setLength(0);
						str.append("0.");
						t.setText(str.toString());}
					else
				        str.append(b[17].getText());
				        t.setText(str.toString());}
		               	}
		else              //点击 其他的数字键
			{
			    str.append(e.getActionCommand());
				t.setText(str.toString());
				y = Double.parseDouble(t.getText().trim());
				}
		} catch (NumberFormatException e1) {
			t.setText("number error!");
		}catch (StringIndexOutOfBoundsException e1) {
			t.setText("beyond error!");
		}
		}
		}
	}
			
		


