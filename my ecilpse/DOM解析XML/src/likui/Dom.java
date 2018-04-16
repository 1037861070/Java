package likui;
import java.util.*;

public class Dom {

public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
	int count;
	Ways ways=new Ways();
	Scanner scr=new Scanner(System.in);
	do {
		System.out.println("请选择你要进行的操作:");
		System.out.println("1.遍历所有学生的各科成绩");
		System.out.println("2.查找一个学生的各科成绩");
		System.out.println("3.添加一个学生各科成绩");
		System.out.println("4.删除一个学生各科成绩");
		System.out.println("5.退出");
		count=scr.nextInt();
		switch (count) {
		case 1:	ways.checkxml();
			break;
		case 2:	System.out.println("学生姓名:");
		   String name=scr.next();
			if (!ways.checkstudent(name)) {
				System.out.print("没有此学生!");
			}
			break;
		case 3:
			ways.insertxml();
			break;
		case 4:System.out.println("学生姓名：");
		String nameString=scr.next();
			if (!ways.deletexml(nameString)) {
				System.out.print("没有此学生!");
			}
			break;
		case 5:	
			break;
		default:
			break;
		}
		
	} while (count!=5); 
     }
}

