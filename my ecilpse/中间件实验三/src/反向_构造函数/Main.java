package ����_���캯��;

import java.util.Scanner;



public class Main {
private static MovieFinder finder;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner scanner=new Scanner(System.in);
    	System.out.println("��������Ҫ��ѯ�ĵ�Ӱ���ƣ�");
    	String name=scanner.next();
    	Movie movie=new Movie();
    	movie.setNameString(name);
    	finder=new MovieFinderImpl();
		MovieLister lister=new MovieLister(finder);
		lister.ways(movie);
	}

}
