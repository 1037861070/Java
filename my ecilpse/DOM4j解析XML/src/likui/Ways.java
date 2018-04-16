package likui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
public class Ways {
	public void checkxml(Element node) {
		
		Iterator itt = node.elementIterator();

		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// 获取book的属性名以及 属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				System.out.println(attr.getName() + "=" + attr.getValue());
			}
			Iterator<Element> it = book.elementIterator();
			// 遍历
			while (it.hasNext()) {
				// 获取某个子节点对象
				Element e = (Element) it.next();
				// 对子节点进行遍历
				System.out.println(e.getName() + ":" + e.getStringValue());
			}
			
		}
	}

	public boolean checkone(String name, Element node) {
		boolean flag = false;
		Iterator itt = node.elementIterator();
		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// 获取book的属性名以及 属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(name)) {
					// 输出所符合的节点属性信息
					System.out.println("雇员信息如下所示 :");
					Iterator its = book.attributeIterator();
					while (its.hasNext()) {
						Attribute attribute = (Attribute) its.next();
						System.out.println(attribute.getName() + ":"
								+ attribute.getValue());
					}
					flag = true;
					Iterator<Element> it = book.elementIterator();
					// 输出这个节点的所有子节点信息
					while (it.hasNext()) {
						// 获取某个子节点对象
						Element e = (Element) it.next();
						// 对子节点进行遍历
						System.out.println(e.getName() + ":"
								+ e.getStringValue());
					}
				}
			}
		}
		System.out.println();
		return flag;
	}

	public boolean modifyexml(String nameString, Element node, Document document)
			throws IOException {
		Scanner scanner=new Scanner(System.in);
		
		boolean flag = false;
		Iterator itt = node.elementIterator();
		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// 获取book的属性名以及 属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(nameString)) {
					Element element=book.element("monthly_pay");
					System.out.print("修改的工资支付类型为：");
					String typeString1=scanner.next();
					System.out.print("修改的工资为：");
					String typeString2=scanner.next();
					element.setText(typeString2);
					Attribute attribute=element.attribute("mode");
					attribute.setValue(typeString1);
					flag = true;
					// 排版缩进的格式
					OutputFormat format = OutputFormat.createPrettyPrint();
					// 设置编码
					format.setEncoding("gb2312");
					// 创建XMLWriter对象,指定了写出文件及编码格式
					// XMLWriter writer = new XMLWriter(new FileWriter(new
					// File("src//a.xml")),format);
					XMLWriter writer = null;
					try {
						writer = new XMLWriter(new OutputStreamWriter(
								new FileOutputStream(new File("src/employees.xml")),
								"gb2312"), format);
					} catch (UnsupportedEncodingException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					// 写入
					try {
						writer.write(document);
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
					// 立即写入
					writer.flush();
					// 关闭操作
					writer.close();
				}
			}
		}
		System.out.println();
		return flag;
	}

	public void insertxml(Element node, Document document) throws IOException {
		boolean flag = false;
		Element newelElement = node.addElement("employee");
		System.out.println("雇员编号：");
		Scanner sc = new Scanner(System.in);
		String string1 = sc.next();
		newelElement.addAttribute("sn", string1);
			System.out.println("输入雇员姓名：");
			String string2 = sc.next();
			System.out.println("输入雇员年龄：");
			String string3 = sc.next();
			System.out.println("输入雇员工资：");
			String salary = sc.next();
			Element e1 = newelElement.addElement("name");
			e1.setText(string2);
			Element e2 = newelElement.addElement("age");
			e2.setText(string3);
			Element e3 = newelElement.addElement("monthly_pay");
			e3.setText(salary);
			int a=Integer.parseInt(salary);
			if (a>2000) {
				e3.addAttribute("mode", "credit_card");
			}
			else {
				e3.addAttribute("mode", "cash");
			}
		// 排版缩进的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("gb2312");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(
					new File("src/employees.xml")), "gb2312"), format);
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 写入
		writer.write(document);
		// 立即写入
		writer.flush();
		// 关闭操作
		writer.close();
	}
}
