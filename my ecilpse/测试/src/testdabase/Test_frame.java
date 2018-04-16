package testdabase;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test_frame extends JFrame{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
  JFrame frame=new JFrame("测试");
  frame.setBounds(20, 30, 300, 200);
  frame.setLayout(new FlowLayout());
  JPanel panel=new JPanel();
  panel.setBounds(40, 60, 220, 120);
  JTextField text1=new JTextField(10);
  JTextField text2=new JTextField(10);
  JButton bt1=new JButton("查询");
  bt1.setSize(5, 5);
  bt1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			Test_databse test=new Test_databse();
			try {
				if(test.query(text1.getText(), text2.getText())){
					JOptionPane.showMessageDialog(panel, "成功", "查询",JOptionPane.WARNING_MESSAGE);  
				}
				else {
					JOptionPane.showMessageDialog(panel, "失败", "查询",JOptionPane.WARNING_MESSAGE); 
				}
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	});
  panel.add(text1);
  panel.add(text2);
  panel.add(bt1);
  frame.add(panel);
  frame.setVisible(true);
 
  
	}

}
