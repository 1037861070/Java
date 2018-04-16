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
	        //������Ҫ�������ĵ�����  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //��ȡ�ĵ���Ԫ��
	Element root = doc.getDocumentElement();         
    //�����ҵ��˸��ڵ㣬���￪ʼ��ȡ���ڵ��µ�Ԫ�ؼ���
	NodeList list = root.getElementsByTagName("ѧ��");
	for (int i = 0; i < list.getLength(); i++) {
         //ͨ��item()�����ҵ������еĽڵ㣬������ת��ΪElement����
    
     Element n = (Element) list.item(i);
         //��ȡ�����е�����map����forѭ����ȡ����ӡ
     String name=n.getAttributes().getNamedItem("name").getNodeValue();
     System.out.println("name: "+name);
     NodeList childNode=n.getElementsByTagName("���Ƴɼ�");
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
	        //������Ҫ�������ĵ�����  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //��ȡ�ĵ���Ԫ��
	Element root = doc.getDocumentElement();         
    //�����ҵ��˸��ڵ㣬���￪ʼ��ȡ���ڵ��µ�Ԫ�ؼ���
	NodeList list = root.getElementsByTagName("ѧ��");
	
	for (int i = 0; i < list.getLength(); i++) {
         //ͨ��item()�����ҵ������еĽڵ㣬������ת��ΪElement����
    
     Element n = (Element) list.item(i);
         //��ȡ�����е�����map����forѭ����ȡ����ӡ
     String name=n.getAttributes().getNamedItem("name").getNodeValue();
     if (name.equals(name1)) {
    	 
    	 System.out.println("name: "+name);
    	 NodeList childNode=n.getElementsByTagName("���Ƴɼ�");
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
	System.out.println("��������ӵ�ѧ����Ϣ��");
	System.out.print("������");
	nameString=sc.next();
	System.out.print("�����������");
	scoreString1=sc.next();
	System.out.print("C���ԣ�");
	scoreString2=sc.next();
	System.out.print("��������磺");
	scoreString3=sc.next();
	System.out.print("XML������");
	scoreString4=sc.next();
	
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //������Ҫ�������ĵ�����  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //��ȡ�ĵ���Ԫ��
	Element root = doc.getDocumentElement();         
    //�����ҵ��˸��ڵ㣬���￪ʼ��ȡ���ڵ��µ�Ԫ�ؼ���
	
	 Element newElement=doc.createElement("ѧ��");
	 Attr attr=doc.createAttribute("name");
	 attr.setValue(nameString);
	 newElement.setAttributeNode(attr);
	 Element newElement2=doc.createElement("���Ƴɼ�");
	 //��������ӽڵ�Ԫ��
	 Element newElement3=doc.createElement("Course");
	 newElement3.setTextContent("���������");
	 Element newElement4=doc.createElement("Score");
	 newElement4.setTextContent(scoreString1);
	 Element newElement5=doc.createElement("Course");
	 newElement5.setTextContent("C����");
	 Element newElement6=doc.createElement("Score");
	 newElement6.setTextContent(scoreString2);
	 Element newElement7=doc.createElement("Course");
	 newElement7.setTextContent("���������");
	 Element newElement8=doc.createElement("Score");
	 newElement8.setTextContent(scoreString3);
	 Element newElement9=doc.createElement("Course");
	 newElement9.setTextContent("XML����");
	 Element newElement10=doc.createElement("Score");
	 newElement10.setTextContent(scoreString4);
	 //ȫ�����뵽�ӽڵ㵱��ȥ
	 newElement2.appendChild(newElement3);
	 newElement2.appendChild(newElement4);
	 newElement2.appendChild(newElement5);
	 newElement2.appendChild(newElement6);
	 newElement2.appendChild(newElement7);
	 newElement2.appendChild(newElement8);
	 newElement2.appendChild(newElement9);
	 newElement2.appendChild(newElement10);
	 newElement.appendChild(newElement2);
	 //���ռ���
	 root.appendChild(newElement);
	//����һ������ת��DOM����Ĺ�������
	 TransformerFactory factory1 = TransformerFactory.newInstance();
	//���ת��������
	 Transformer t = factory1.newTransformer();
	//����Ҫת����Դ����
	 DOMSource xml = new DOMSource(doc);
	//����Ҫת������Ŀ���ļ�
	 StreamResult s = new StreamResult(new File("src/test4.xml"));
	 t.transform(xml, s);
	
}
public boolean deletexml(String nameString) throws Exception, IOException{
	boolean flag=false;
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	        //������Ҫ�������ĵ�����  
	File f = new File("src/test4.xml");
	Document doc = builder.parse(f);    
	 //��ȡ�ĵ���Ԫ��
	Element root = doc.getDocumentElement();  
	NodeList nodeList=root.getElementsByTagName("ѧ��");
	for(int i=0;i<nodeList.getLength();i++)
	{
		Element n = (Element) nodeList.item(i);
		if (n.getAttribute("name").equals(nameString)) {
			root.removeChild(nodeList.item(i));
			TransformerFactory factory1 = TransformerFactory.newInstance();
			//���ת��������
			 Transformer t = factory1.newTransformer();
			//����Ҫת����Դ����
			 DOMSource xml = new DOMSource(doc);
			//����Ҫת������Ŀ���ļ�
			 StreamResult s = new StreamResult(new File("src/test4.xml"));
			 t.transform(xml, s);
			 System.out.println("ɾ���ɹ���");
			 flag=true;
		}
		
	}
	return flag;
	
}

}
