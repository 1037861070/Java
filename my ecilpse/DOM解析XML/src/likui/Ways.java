package likui;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ways {
public void checkxml() throws  Exception{
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //创建需要解析的文档对象  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //获取文档根元素
	Element root = doc.getDocumentElement();         
    //上面找到了根节点，这里开始获取根节点下的元素集合
	NodeList list = root.getElementsByTagName("学生");
	for (int i = 0; i < list.getLength(); i++) {
         //通过item()方法找到集合中的节点，并向下转型为Element对象
    
     Element n = (Element) list.item(i);
         //获取对象中的属性map，用for循环提取并打印
     String name=n.getAttributes().getNamedItem("name").getNodeValue();
     System.out.println("name: "+name);
     NodeList childNode=n.getElementsByTagName("各科成绩");
     Element nn=(Element) childNode.item(0);
     String allString=nn.getNodeName();
     System.out.println(allString);
    	 NodeList childNodes=nn.getChildNodes();
     for (int j = 0; j < childNodes.getLength(); j++) {
    	 if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){ 
    		 if("Course".equals(childNodes.item(j).getNodeName())){ 
    			 String course=childNodes.item(j).getFirstChild().getNodeValue();
    			 System.out.println("course: "+course);
    		 }else if ("Score".equals(childNodes.item(j).getNodeName())) {
				String score=childNodes.item(j).getFirstChild().getNodeValue();
				 System.out.println("score: "+score);
			}
    	 }	
	}
     System.out.println(); 
	}
}
public boolean checkstudent(String name1) throws Exception{
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //创建需要解析的文档对象  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //获取文档根元素
	Element root = doc.getDocumentElement();         
    //上面找到了根节点，这里开始获取根节点下的元素集合
	NodeList list = root.getElementsByTagName("学生");
	
	for (int i = 0; i < list.getLength(); i++) {
         //通过item()方法找到集合中的节点，并向下转型为Element对象
    
     Element n = (Element) list.item(i);
         //获取对象中的属性map，用for循环提取并打印
     String name=n.getAttributes().getNamedItem("name").getNodeValue();
     if (name.equals(name1)) {
    	 
    	 System.out.println("name: "+name);
    	 NodeList childNode=n.getElementsByTagName("各科成绩");
         Element nn=(Element) childNode.item(0);
         String allString=nn.getNodeName();
         System.out.println(allString);
        	 NodeList childNodes=nn.getChildNodes();
         for (int j = 0; j < childNodes.getLength(); j++) {
        	 if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){ 
        		 if("Course".equals(childNodes.item(j).getNodeName())){ 
        			 String course=childNodes.item(j).getFirstChild().getNodeValue();
        			 System.out.println("course: "+course);
        		 }else if ("Score".equals(childNodes.item(j).getNodeName())) {
    				String score=childNodes.item(j).getFirstChild().getNodeValue();
    				 System.out.println("score: "+score);
    			}
        	 }
	} 
        
         return true;
	}
     System.out.println(); 
	}
	return false;
}
public void insertxml() throws Exception, IOException{
	Scanner sc=new Scanner(System.in);

	String nameString;
	String scoreString1,scoreString2,scoreString3,scoreString4;
	System.out.println("请输入添加的学生信息：");
	System.out.print("姓名：");
	nameString=sc.next();
	System.out.print("计算机基础：");
	scoreString1=sc.next();
	System.out.print("C语言：");
	scoreString2=sc.next();
	System.out.print("计算机网络：");
	scoreString3=sc.next();
	System.out.print("XML技术：");
	scoreString4=sc.next();
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //创建需要解析的文档对象  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //获取文档根元素
	Element root = doc.getDocumentElement();         
    //上面找到了根节点，这里开始获取根节点下的元素集合
	
	 Element newElement=doc.createElement("学生");
	 Attr attr=doc.createAttribute("name");
	 attr.setValue(nameString);
	 newElement.setAttributeNode(attr);
	 Element newElement2=doc.createElement("各科成绩");
	 //添加所有子节点元素
	 Element newElement3=doc.createElement("Course");
	 newElement3.setTextContent("计算机基础");
	 Element newElement4=doc.createElement("Score");
	 newElement4.setTextContent(scoreString1);
	 Element newElement5=doc.createElement("Course");
	 newElement5.setTextContent("C语言");
	 Element newElement6=doc.createElement("Score");
	 newElement6.setTextContent(scoreString2);
	 Element newElement7=doc.createElement("Course");
	 newElement7.setTextContent("计算机网络");
	 Element newElement8=doc.createElement("Score");
	 newElement8.setTextContent(scoreString3);
	 Element newElement9=doc.createElement("Course");
	 newElement9.setTextContent("XML技术");
	 Element newElement10=doc.createElement("Score");
	 newElement10.setTextContent(scoreString4);
	 //全部加入到子节点当中去
	 newElement2.appendChild(newElement3);
	 newElement2.appendChild(newElement4);
	 newElement2.appendChild(newElement5);
	 newElement2.appendChild(newElement6);
	 newElement2.appendChild(newElement7);
	 newElement2.appendChild(newElement8);
	 newElement2.appendChild(newElement9);
	 newElement2.appendChild(newElement10);
	 newElement.appendChild(newElement2);
	 //最终加入
	 root.appendChild(newElement);
	//创建一个用来转换DOM对象的工厂对象
	 TransformerFactory factory1 = TransformerFactory.newInstance();
	//获得转换器对象
	 Transformer t = factory1.newTransformer();
	//定义要转换的源对象
	 DOMSource xml = new DOMSource(doc);
	//定义要转换到的目标文件
	 StreamResult s = new StreamResult(new File("src/test4.xml"));
	 t.transform(xml, s);
	
}
public boolean deletexml(String nameString) throws Exception, IOException{
	boolean flag=false;
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //创建需要解析的文档对象  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //获取文档根元素
	Element root = doc.getDocumentElement();  
	NodeList nodeList=root.getElementsByTagName("学生");
	for(int i=0;i<nodeList.getLength();i++)
	{
		Element n = (Element) nodeList.item(i);
		if (n.getAttribute("name").equals(nameString)) {
			root.removeChild(nodeList.item(i));
			TransformerFactory factory1 = TransformerFactory.newInstance();
			//获得转换器对象
			 Transformer t = factory1.newTransformer();
			//定义要转换的源对象
			 DOMSource xml = new DOMSource(doc);
			//定义要转换到的目标文件
			 StreamResult s = new StreamResult(new File("src/test4.xml"));
			 t.transform(xml, s);
			 System.out.println("删除成功！");
			 flag=true;
		}
		
	}
	return flag;
	
}

}
