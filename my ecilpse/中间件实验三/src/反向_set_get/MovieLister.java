package 反向_set_get;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class MovieLister {
	private MovieFinder finder;
	private Movie movie1;
    public MovieLister(){	
    }
    public MovieFinder getFinder() {
		return finder;
	}
	public void setFinder(MovieFinder finder) {
		this.finder = finder;
	}
	public void ways(Movie movie){	
    	boolean flag=false;
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
