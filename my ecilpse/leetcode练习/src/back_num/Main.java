package back_num;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		// System.out.println("����ԭʼ����");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m;
		StringBuffer arrBuffer = new StringBuffer();
		arrBuffer.append(n);
		String s = arrBuffer.reverse().toString();
		m = Integer.parseInt(s);
		System.out.print(m + n);
	}

}
