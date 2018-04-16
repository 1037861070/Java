package xml课程设计;

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
	private String namesString;
	private String start_timeString;
	private String end_timeString;

	public String getNamesString() {
		return namesString;
	}

	public void setNamesString(String namesString) {
		this.namesString = namesString;
	}

	public String getStart_timeString() {
		return start_timeString;
	}

	public void setStart_timeString(String start_timeString) {
		this.start_timeString = start_timeString;
	}

	public String getEnd_timeString() {
		return end_timeString;
	}

	public void setEnd_timeString(String end_timeString) {
		this.end_timeString = end_timeString;
	}

	public void checkxml(Element node) {
		System.out.println(node.getName() + ":");
		List<Attribute> bookAttr = node.attributes();
		for (Attribute attr : bookAttr) {
			System.out.println(attr.getName() + ":" + attr.getValue());
		}
		Iterator itt = node.elementIterator();

		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// 获取book的属性名以及 属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				System.out.println(attr.getName() + ":" + attr.getValue());
			}
			Iterator<Element> it = book.elementIterator();
			// 遍历
			while (it.hasNext()) {
				// 获取某个子节点对象
				Element e = (Element) it.next();
				// 对子节点进行遍历
				System.out.println(e.getName() + ":" + e.getStringValue());
			}
			System.out.println();
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

	public boolean deletexml(String nameString, Element node, Document document)
			throws IOException {
		boolean flag = false;
		Iterator itt = node.elementIterator();
		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// 获取book的属性名以及 属性值
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(nameString)) {
					node.remove(book);
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
								new FileOutputStream(new File("src/bbb.xml")),
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
		Element newelElement = node.addElement("线路");
		System.out.println("公交车名：");
		Scanner sc = new Scanner(System.in);
		String string1 = sc.next();
		newelElement.addAttribute("公交车", string1);
		System.out.println("开始时间：");
		String string2 = sc.next();
		newelElement.addAttribute("开始时间", string2);
		System.out.println("结束时间：");
		String string3 = sc.next();
		newelElement.addAttribute("结束时间", string3);
		System.out.println("输入添加站点个数：");
		int a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			System.out.println("输入站点信息：");
			String string = sc.next();
			Element e = newelElement.addElement("站点");
			e.setText(string);
		}
		// 排版缩进的格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("gb2312");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(
					new File("src/bbb.xml")), "gb2312"), format);
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
