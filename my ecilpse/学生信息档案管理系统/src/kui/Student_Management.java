package kui;

import java.util.Scanner;


public class Student_Management {
	public static void main(String[] args) {
	int i=-1;
	 String name1,number1,classname1,grade1;
	 
	 Hashtable_map map=new  Hashtable_map();
	System.out.println("欢迎进入学生成绩管理系统！");
	while(i!=8)
	{
		System.out.println("1.添加学生信息：");
		System.out.println("2.修改学生信息：");
		System.out.println("3.查找学生信息：");
		System.out.println("4.显示所有学生信息：");
		System.out.println("5.统计所有学生的平均成绩：");
		System.out.println("6.显示学生的最高成绩：");
		System.out.println("7.显示特定分数段学生信息：");
		System.out.println("8.退出系统！");
		System.out.println("请输入选项：");
	   @SuppressWarnings("resource")
	    Scanner input=new Scanner(System.in);
	   i=input.nextInt();
	   switch(i){
	   case 1:
		      StudentMessage likui=new StudentMessage(); 
		      System.out.println("请输入添加的学生信息：");
	          System.out.print("姓名：");
	          name1=input.next();
	          likui.setName(name1);
	          System.out.print("学号：");
	          number1=input.next();
	          likui.setNumber(number1);
	          System.out.print("班级：");
	          classname1=input.next();
	          likui.setClassname(classname1);
	          System.out.print("成绩(0-100)：");
              grade1=input.next();
              if(Double.parseDouble(grade1)<0||Double.parseDouble(grade1)>100)
              {
            	  System.out.println("输入错误！,请重新选择操作项！");
              break;
              }
              else  
             likui.setGrade(grade1);
             map.addNewStudent(classname1,likui);
            	
		      break;
	   case 2:System.out.println("请输入要修改的学生姓名：");
	          String Name=input.next();
	          StudentMessage li=new StudentMessage();
	          //li=check(Name,kui);
	          li=map.checklisting(Name);
	          if(li.getName()==null)
	          { System.out.println("没有此学生！");
	               break;}
	          else
	          System.out.print("修改学号为:");
	          number1=input.next();
              li.setNumber(number1);
              System.out.print("班级为:");
              classname1=input.next();
              li.setClassname(classname1);
              System.out.print("成绩为：");
              grade1=input.next();
              li.setGrade(grade1);
              System.out.println("修改完毕！");
		      break;
	   case 3:System.out.print("请输入要查找学生的姓名：");
	          name1=input.next();
	          StudentMessage kui=new StudentMessage();
	          kui=map.checklisting(name1);
	          if(kui.getName()==null)
	          { System.out.println("没有此学生！");
	               break;}
	          else
	          System.out.println("查找到的学生信息如下所示：");
	          System.out.println("姓名\t"+kui.getName()+"  学号\t"+kui.getNumber()+
	        		  "  班级\t"+kui.getClassname()+"  成绩\t"+kui.getGrade());
		      break;
	   case 4:
	          map.printListings();
	          
		      break;
	   case 5:
		       map.arvegegrade();
		      break;
	   case 6:
		     map.Maxgrade();
		      break;
	   case 7:
		   map.printgrade();
		      break;
	 
	   }
	}
             System.out.println("谢谢使用！");}

}


