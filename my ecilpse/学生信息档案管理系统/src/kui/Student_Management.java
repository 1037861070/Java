package kui;

import java.util.Scanner;


public class Student_Management {
	public static void main(String[] args) {
	int i=-1;
	 String name1,number1,classname1,grade1;
	 
	 Hashtable_map map=new  Hashtable_map();
	System.out.println("��ӭ����ѧ���ɼ�����ϵͳ��");
	while(i!=8)
	{
		System.out.println("1.���ѧ����Ϣ��");
		System.out.println("2.�޸�ѧ����Ϣ��");
		System.out.println("3.����ѧ����Ϣ��");
		System.out.println("4.��ʾ����ѧ����Ϣ��");
		System.out.println("5.ͳ������ѧ����ƽ���ɼ���");
		System.out.println("6.��ʾѧ������߳ɼ���");
		System.out.println("7.��ʾ�ض�������ѧ����Ϣ��");
		System.out.println("8.�˳�ϵͳ��");
		System.out.println("������ѡ�");
	   @SuppressWarnings("resource")
	    Scanner input=new Scanner(System.in);
	   i=input.nextInt();
	   switch(i){
	   case 1:
		      StudentMessage likui=new StudentMessage(); 
		      System.out.println("��������ӵ�ѧ����Ϣ��");
	          System.out.print("������");
	          name1=input.next();
	          likui.setName(name1);
	          System.out.print("ѧ�ţ�");
	          number1=input.next();
	          likui.setNumber(number1);
	          System.out.print("�༶��");
	          classname1=input.next();
	          likui.setClassname(classname1);
	          System.out.print("�ɼ�(0-100)��");
              grade1=input.next();
              if(Double.parseDouble(grade1)<0||Double.parseDouble(grade1)>100)
              {
            	  System.out.println("�������,������ѡ������");
              break;
              }
              else  
             likui.setGrade(grade1);
             map.addNewStudent(classname1,likui);
            	
		      break;
	   case 2:System.out.println("������Ҫ�޸ĵ�ѧ��������");
	          String Name=input.next();
	          StudentMessage li=new StudentMessage();
	          //li=check(Name,kui);
	          li=map.checklisting(Name);
	          if(li.getName()==null)
	          { System.out.println("û�д�ѧ����");
	               break;}
	          else
	          System.out.print("�޸�ѧ��Ϊ:");
	          number1=input.next();
              li.setNumber(number1);
              System.out.print("�༶Ϊ:");
              classname1=input.next();
              li.setClassname(classname1);
              System.out.print("�ɼ�Ϊ��");
              grade1=input.next();
              li.setGrade(grade1);
              System.out.println("�޸���ϣ�");
		      break;
	   case 3:System.out.print("������Ҫ����ѧ����������");
	          name1=input.next();
	          StudentMessage kui=new StudentMessage();
	          kui=map.checklisting(name1);
	          if(kui.getName()==null)
	          { System.out.println("û�д�ѧ����");
	               break;}
	          else
	          System.out.println("���ҵ���ѧ����Ϣ������ʾ��");
	          System.out.println("����\t"+kui.getName()+"  ѧ��\t"+kui.getNumber()+
	        		  "  �༶\t"+kui.getClassname()+"  �ɼ�\t"+kui.getGrade());
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
             System.out.println("ллʹ�ã�");}

}


