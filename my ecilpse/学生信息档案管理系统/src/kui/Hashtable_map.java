package kui;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;




public class Hashtable_map {
	private  Map<String, StudentMessage> students;
	Double n=0.0,m=0.0;
	int z=0;
@SuppressWarnings("unchecked")
public Hashtable_map(){
	this.students=new Hashtable<String, StudentMessage>();    //创建hashtable
}

public void addNewStudent(String classname1,StudentMessage stu)
{
    this.students.put(classname1, stu);
}
//打印学生信息
public void printListings()    
{
    Iterator it =this.students.entrySet().iterator();
    System.out.println("学生信息如下所示：");
    System.out.println("姓名\t\t"+"学号\t\t"+"班级\t\t"+"成绩\t\t");
    while(it.hasNext())
    {
        Map.Entry ptr=(Map.Entry)it.next();
       StudentMessage student =(StudentMessage) ptr.getValue();
       System.out.println(student.getName()+"\t\t"+student.getNumber()+"\t\t"+
   			student.getClassname()+"\t\t"+student.getGrade()); 
    }
}
//查找操作
public StudentMessage checklisting(String name){ 
	StudentMessage a=new StudentMessage();
	 Iterator it =this.students.entrySet().iterator();
    while(it.hasNext()){
    	  Map.Entry ptr=(Map.Entry)it.next();
    	  StudentMessage student =(StudentMessage) ptr.getValue();
    	if(student.getName().equals(name))
        {
    		a=student;
    	    break;}
    }
    return a;
}
//计算平均成绩
public void arvegegrade(){        
	 Iterator it =this.students.entrySet().iterator();
	    while(it.hasNext())
	    {
	       Map.Entry ptr=(Map.Entry)it.next();
	       StudentMessage student =(StudentMessage) ptr.getValue();
    	   n=Double.parseDouble(student.getGrade());
    	++z;
    	m=m+n;
    }
    System.out.printf("平均成绩为：%.2f",m/z);
    System.out.println();
}
//显示最高成绩
public void Maxgrade(){
	m=0.0;
	 Iterator it =this.students.entrySet().iterator();
	    while(it.hasNext())
	    {
	       Map.Entry ptr=(Map.Entry)it.next();
	       StudentMessage student =(StudentMessage) ptr.getValue();
    	n=Double.parseDouble(student.getGrade());
    	if(m<n)
    		m=n;
    }
    System.out.println("学生中成绩最高为："+m);
}
//显示特定分数段学生成绩
public void printgrade(){        
	Double y=0.0;
	Map A=new Hashtable();
	Map B=new Hashtable();
	Map C=new Hashtable();
	Map D=new Hashtable();
	Map E=new Hashtable();
	 Iterator it =this.students.entrySet().iterator();
	    while(it.hasNext())
	    {
	       Map.Entry ptr=(Map.Entry)it.next();
	       StudentMessage student =(StudentMessage) ptr.getValue();
    	y=Double.parseDouble(student.getGrade());
    	if(y<60)
    		E.put(student.getClassname(),student);
    	else if(y>=60&&y<70)
    	    D.put(student.getClassname(),student);
    	else if(y>=70&&y<80)
    		C.put(student.getClassname(),student);
    	else if(y>=80&&y<90)
    		B.put(student.getClassname(),student);
    	else if(y>=90&&y<=100)
    		A.put(student.getClassname(),student);
    }	
    Iterator it1=A.entrySet().iterator();
    Iterator it2=B.entrySet().iterator();
    Iterator it3=C.entrySet().iterator();
    Iterator it4=D.entrySet().iterator();
    Iterator it5=E.entrySet().iterator();
    System.out.println("60分以下学生为：");
    while(it5.hasNext())
    {
    	Map.Entry ptr5=(Map.Entry)it5.next();
	    StudentMessage e =(StudentMessage) ptr5.getValue();
	   
    	System.out.println(e.getName());
    }
    System.out.println("60-70分以内学生为：");
    while(it4.hasNext())
    {
    	Map.Entry ptr4=(Map.Entry)it4.next();
	    StudentMessage d =(StudentMessage) ptr4.getValue();
	  
    	System.out.println(d.getName());
    }
    System.out.println("70-80分以内学生为：");
    while(it3.hasNext())
    {
    	Map.Entry ptr3=(Map.Entry)it3.next();
	    StudentMessage c =(StudentMessage) ptr3.getValue();
	   
    	System.out.println(c.getName());
    }
    System.out.println("80-90分以内学生为：");
    while(it2.hasNext())
    {
    	Map.Entry ptr2=(Map.Entry)it2.next();
	    StudentMessage b =(StudentMessage) ptr2.getValue();
	    
    	 System.out.println(b.getName());
    }
    System.out.println("90-100分以内学生为：");
    while(it1.hasNext())
    {
    	Map.Entry ptr1=(Map.Entry)it1.next();
	    StudentMessage a =(StudentMessage) ptr1.getValue();
	  
    	 System.out.println(a.getName());
    }
}
}
