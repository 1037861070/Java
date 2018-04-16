package 面向对象;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieLister {
	private static MovieFinder finder;
	private static Movie movie1;
	static boolean flag=false;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	Scanner scanner=new Scanner(System.in);
	System.out.println("请输入你要查询的电影名称！");
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
		   System.out.println("电影名称:\t"+"电影价格\t\t "+"电影开始时间");
			System.out.println(movie1.getNameString()+"\t\t"+movie1.getPricesString()+"\t\t"+movie1.getDateString());
	}
	   else {
		System.out.println("没有此电影信息！");
	}
	}

}
