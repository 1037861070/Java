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
			// ��ȡbook���������Լ� ����ֵ
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				System.out.println(attr.getName() + "=" + attr.getValue());
			}
			Iterator<Element> it = book.elementIterator();
			// ����
			while (it.hasNext()) {
				// ��ȡĳ���ӽڵ����
				Element e = (Element) it.next();
				// ���ӽڵ���б���
				System.out.println(e.getName() + ":" + e.getStringValue());
			}
			
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
					System.out.println("��Ա��Ϣ������ʾ :");
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

	public boolean modifyexml(String nameString, Element node, Document document)
			throws IOException {
		Scanner scanner=new Scanner(System.in);
		
		boolean flag = false;
		Iterator itt = node.elementIterator();
		while (itt.hasNext()) {
			Element book = (Element) itt.next();
			// ��ȡbook���������Լ� ����ֵ
			List<Attribute> bookAttrs = book.attributes();
			for (Attribute attr : bookAttrs) {
				if (attr.getValue().equals(nameString)) {
					Element element=book.element("monthly_pay");
					System.out.print("�޸ĵĹ���֧������Ϊ��");
					String typeString1=scanner.next();
					System.out.print("�޸ĵĹ���Ϊ��");
					String typeString2=scanner.next();
					element.setText(typeString2);
					Attribute attribute=element.attribute("mode");
					attribute.setValue(typeString1);
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
								new FileOutputStream(new File("src/employees.xml")),
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
		Element newelElement = node.addElement("employee");
		System.out.println("��Ա��ţ�");
		Scanner sc = new Scanner(System.in);
		String string1 = sc.next();
		newelElement.addAttribute("sn", string1);
			System.out.println("�����Ա������");
			String string2 = sc.next();
			System.out.println("�����Ա���䣺");
			String string3 = sc.next();
			System.out.println("�����Ա���ʣ�");
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
		// �Ű������ĸ�ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// ���ñ���
		format.setEncoding("gb2312");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(
					new File("src/employees.xml")), "gb2312"), format);
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
