package longestpalindromicsubstring;

//Given a string s, find the longest palindromic substring in s.

class Solution {
    public String longestPalindrome(String s) {
    	StringBuilder stringBuffer=new StringBuilder();
    	String str1,str2,str3="";
    	for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) { 
				stringBuffer.setLength(0);
				str1=s.substring(i, j+1);           //��ȡi��j���ַ���
				stringBuffer.append(str1);       //���뻺����
				str2=stringBuffer.reverse().toString();//��ת��ת�����ַ���
				if (str1.equals(str2)) {          //�Ƚ������Ƿ�һ��
				//	System.out.println(str3.length());       
					if (str3.length()<str1.length()) {
						str3=str2;                //�õ������������ַ���
					}
				
					 
				}
				
			}
		}
        return str3;
       
    }
}
public class Main {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
          System.out.println(new Solution().longestPalindrome("rgczcpratwyqxaszbuwwcadruayhasynuxna"
          		+ "kpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjdd"
          		+ "mhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurv"
          		+ "izgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjff"
          		+ "rgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxh"
          		+ "tizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycs"
          		+ "wwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrk"
          		+ "xclykccbwridpqckstxdjawvziucrswpsfmisqiozwor"
          		+ "ibeycuarcidbljslwbalcemgymnsxfziattdylrulwry"
          		+ "bzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjj"
          		+ "gqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdy"
          		+ "klrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnux"
          		+ "wmuklntnyycdcscioimenaeohgpbcpogyifcsatfxesl"
          		+ "stkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbw"
          		+ "kvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpres"
          		+ "noacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwp"
          		+ "eykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwz"
          		+ "udnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexp"
          		+ "lpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhq"
          		+ "lbqbcestadoxtrdvcgucntjnfavylip"));
	}
}
