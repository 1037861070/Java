package �������;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieLister {
	private static MovieFinder finder;
	private static Movie movie1;
	static boolean flag=false;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
	Scanner scanner=new Scanner(System.in);
	System.out.println("��������Ҫ��ѯ�ĵ�Ӱ���ƣ�");
	String name=scanner.next();
	Movie movie=new Movie();
	movie.setNameString(name);
	finder = new MovieFinderImpl();
    List allmovies=finder.findall();
    Iterator iterator=allmovies.iterator();
   while(iterator.hasNext()){
	   Movie movie2=(Movie) iterator.next();
	   if (movie.getNameString().equals(movie2.getNameString())) {
		  flag=true; 
		  movie1=movie2;
		
	}}

   if (flag) {
		   System.out.println("��Ӱ����:\t"+"��Ӱ�۸�\t\t "+"��Ӱ��ʼʱ��");
			System.out.println(movie1.getNameString()+"\t\t"+movie1.getPricesString()+"\t\t"+movie1.getDateString());
	}
	   else {
		System.out.println("û�д˵�Ӱ��Ϣ��");
	}
	}

}
