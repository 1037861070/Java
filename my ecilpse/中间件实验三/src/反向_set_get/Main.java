package 反向_set_get;

import java.util.Scanner;



public class Main {
private static MovieFinder finder;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner scanner=new Scanner(System.in);
    	System.out.println("请输入你要查询的电影名称！");
    	String name=scanner.next();
    	Movie movie=new Movie();
    	movie.setNameString(name);
    	finder=new MovieFinderImpl();
		MovieLister lister=new MovieLister();
		lister.setFinder(finder);
		lister.ways(movie);
	}

}
