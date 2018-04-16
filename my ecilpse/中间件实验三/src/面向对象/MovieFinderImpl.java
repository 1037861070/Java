package 面向对象;

import java.util.ArrayList;
import java.util.List;



public class MovieFinderImpl implements MovieFinder{
	private List list;
	private String name;
public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List  findall(){
	Movie a1=new Movie("上海滩","30","2017-5-20 10:25");
	Movie a2=new Movie("嘻哈记","35","2017-5-20 13:25");
	Movie a3=new Movie("生化危机7","33","2017-5-20 15:25");
	Movie a4=new Movie("金刚狼","38","2017-5-20 22:25");
    List list=new ArrayList();
	list.add(a1);
	list.add(a2);
	list.add(a3);
	list.add(a4);
	return list;
	
	
}
}
