package xml�γ����;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int count;
		SAXReader reader = new SAXReader();
		// ͨ��read������ȡһ���ļ� ת����Document����
		Document document = null;
		try {
			document = reader.read(new File("src/bbb.xml"));
		} catch (DocumentException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		// ��ȡ���ڵ�Ԫ�ض���
		Element node = document.getRootElement();
		Ways ways = new Ways();
		Scanner scr = new Scanner(System.in);
		do {
			System.out.println("��ӭʹ�ã�");
			System.out.println("��ѡ����Ҫ���еĲ���:");
			System.out.println("1.�������й�����·��վ����Ϣ");
			System.out.println("2.����һ��������·��վ����Ϣ");
			System.out.println("3.ɾ��һ��������·��վ����Ϣ");
			System.out.println("4.���һ��������·��վ����Ϣ");
			System.out.println("5.�˳�");
			count = scr.nextInt();
			switch (count) {
			case 1:
				ways.checkxml(node);
				break;
			case 2:
				System.out.println("��������:");
				String name1 = scr.next();
				// ways.checkone(name,node);
				if (!ways.checkone(name1, node)) {
					System.out.print("û�д���·!");
				}
				break;
			case 3:
				System.out.println("��������:");
				String name2 = scr.next();
				try {
					if (ways.deletexml(name2, node,document)) {
						System.out.print("ɾ���ɹ�!");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					ways.insertxml(node,document);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				break;
			case 5:System.out.println("ллʹ�ã�");
				break;
			default:
				break;
			}

		} while (count != 5);
	}
}
