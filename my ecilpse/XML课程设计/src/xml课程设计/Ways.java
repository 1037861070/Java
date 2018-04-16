package xml�γ����;

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
			// ��ȡbook���������Լ� ����ֵ
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				System.out.println(attr.getName() + ":" + attr.getValue());
			}
			Iterator<Element> it = book.elementIterator();
			// ����
			while (it.hasNext()) {
				// ��ȡĳ���ӽڵ����
				Element e = (Element) it.next();
				// ���ӽڵ���б���
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
			// ��ȡbook���������Լ� ����ֵ
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(name)) {
					// ��������ϵĽڵ�������Ϣ
					Iterator its = book.attributeIterator();
					while (its.hasNext()) {
						Attribute attribute = (Attribute) its.next();
						System.out.println(attribute.getName() + ":"
								+ attribute.getValue());
					}
					flag = true;
					Iterator<Element> it = book.elementIterator();
					// �������ڵ�������ӽڵ���Ϣ
					while (it.hasNext()) {
						// ��ȡĳ���ӽڵ����
						Element e = (Element) it.next();
						// ���ӽڵ���б���
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
			// ��ȡbook���������Լ� ����ֵ
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(nameString)) {
					node.remove(book);
					flag = true;
					// �Ű������ĸ�ʽ
					OutputFormat format = OutputFormat.createPrettyPrint();
					// ���ñ���
					format.setEncoding("gb2312");
					// ����XMLWriter����,ָ����д���ļ��������ʽ
					// XMLWriter writer = new XMLWriter(new FileWriter(new
					// File("src//a.xml")),format);
					XMLWriter writer = null;
					try {
						writer = new XMLWriter(new OutputStreamWriter(
								new FileOutputStream(new File("src/bbb.xml")),
								"gb2312"), format);
					} catch (UnsupportedEncodingException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						// TODO �Զ����ɵ� catch ��
						e1.printStackTrace();
					}
					// д��
					try {
						writer.write(document);
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
					// ����д��
					writer.flush();
					// �رղ���
					writer.close();
				}
			}
		}
		System.out.println();
		return flag;
	}

	public void insertxml(Element node, Document document) throws IOException {
		boolean flag = false;
		Element newelElement = node.addElement("��·");
		System.out.println("����������");
		Scanner sc = new Scanner(System.in);
		String string1 = sc.next();
		newelElement.addAttribute("������", string1);
		System.out.println("��ʼʱ�䣺");
		String string2 = sc.next();
		newelElement.addAttribute("��ʼʱ��", string2);
		System.out.println("����ʱ�䣺");
		String string3 = sc.next();
		newelElement.addAttribute("����ʱ��", string3);
		System.out.println("�������վ�������");
		int a = sc.nextInt();
		for (int i = 0; i < a; i++) {
			System.out.println("����վ����Ϣ��");
			String string = sc.next();
			Element e = newelElement.addElement("վ��");
			e.setText(string);
		}
		// �Ű������ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// ���ñ���
		format.setEncoding("gb2312");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(
					new File("src/bbb.xml")), "gb2312"), format);
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		// д��
		writer.write(document);
		// ����д��
		writer.flush();
		// �رղ���
		writer.close();
	}
}
