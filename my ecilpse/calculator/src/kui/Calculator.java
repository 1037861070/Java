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
static String name[]={"C","��","X^","+","7","8","9","-","4","5","6","*","1","2"
		 ,"3","/","0",".","%","="};
static double x,y;
static int z;

public static void main(String[] args) {   //������
		// TODO �Զ����ɵķ������
f.setTitle("��������");
f.setLayout(null);
f.setBounds(20, 20, 280, 340);
f.setLocationRelativeTo(null);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���ùرն���

 p1.setBounds(20, 20, 233, 40);               
 t.setBackground(Color.yellow);               //�����������ɫ
 t.setHorizontalAlignment(JTextField.RIGHT);  //�����־���
 
 t.setEditable(false); //�������ʾ����Ϊ����д
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
	
class Listener implements ActionListener {    //�¼���������
	public void actionPerformed(ActionEvent e) {
	try{
		if (e.getSource() == b[16])// ���ѡ�����"0"������ּ�
		{
		if (t.getText().trim().equals("0"))// �����ʾ����ʾ��Ϊ�㲻������
		{

		} else {
			str.append(e.getActionCommand());
			t.setText(str.toString());
			y = Double.parseDouble(t.getText().trim());
			}
		}	
		else if(e.getSource()==b[0]) //�������
		{
			t.setText("0");
			str.setLength(0);    //����������ַ���
			}
		else if(e.getSource()==b[3])  //�ӷ�����		
		{
			x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=1;
			}
		else if(e.getSource()==b[7])  //��������͸��Ų���
		{
		    if(t.getText().trim().equals("0"))  //������Ų���
				{
					str.append(b[7].getText());
					t.setText(str.toString());
				}
				else{                          //��������
				x=Double.parseDouble(t.getText().trim());
				str.setLength(0);
				z=2;}
			}
		else if(e.getSource()==b[11])  //�˷�����
		{
			x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=3;
			}
		else if(e.getSource()==b[15])   //��������
		{
		    x=Double.parseDouble(t.getText().trim());
		    str.setLength(0);
		    z=4;
			}
		else if(e.getSource()==b[2])   //n�η�
		{
		    x=Double.parseDouble(t.getText().trim());
			str.setLength(0);
			z=5;
			}
		else if(e.getSource()==b[19])     //��ʾ���
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
		else if(e.getSource()==b[1]) //��������
			{  	
				x=Double.parseDouble(t.getText().trim());
				if(x<0)
				t.setText("����û��ƽ������");
				else
				t.setText("" + Math.sqrt(x));
				str.setLength(0);        
			}
		else if(e.getSource()==b[17])
			{
				if (t.getText().trim().indexOf('.') != -1)// �ж��ַ������Ƿ��Ѿ�������С����
				{}   //�����κβ���
				else{                         //��ʾ��ʾΪ0
					if(t.getText().trim().equals("0")){
						str.setLength(0);
						str.append("0.");
						t.setText(str.toString());}
					else
				        str.append(b[17].getText());
				        t.setText(str.toString());}
		               	}
		else              //��� ���������ּ�
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
			
		


