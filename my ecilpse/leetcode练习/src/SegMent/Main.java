package SegMent;

/*һ����Сд��ĸ��ɵ��ַ���
 ���Կ���һЩͬһ��ĸ�������Ƭ��ɵġ�
 ����,"aaabbaaac"����������Ƭ��ɵ�:'aaa','bb','c'��ţţ���ڸ���һ���ַ���,
 ���������������ַ�����������Ƭ��ƽ�������Ƕ��١�*/
import java.util.Scanner;

class Ways {
	public float method(String s) {
		int m = 1, sum = 1;
		int n=0;
		char c = s.charAt(m-1);
		for (int i = 0; i < s.length() - 1; i++) {
			if (c == s.charAt(i + 1)) {
				m++;
			} else {
				// flag=true;
				n++;
				sum = sum + m;
				m = 1;
				c = s.charAt(i + 1);
			}
		}
		float n1=(float)n;
		float sum1=(float)sum;
		return (sum1/n1);
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		Ways ways = new Ways();
		
		System.out.format("%.2f",ways.method(string));
	}

}
