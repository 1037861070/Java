package SegMent;

/*一个由小写字母组成的字符串
 可以看成一些同一字母的最大碎片组成的。
 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,
 请你帮助计算这个字符串的所有碎片的平均长度是多少。*/
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
		// TODO 自动生成的方法存根
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		Ways ways = new Ways();
		
		System.out.format("%.2f",ways.method(string));
	}

}
