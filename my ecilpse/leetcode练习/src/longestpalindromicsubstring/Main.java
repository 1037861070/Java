package longestpalindromicsubstring;

//Given a string s, find the longest palindromic substring in s.

class Solution {
    public String longestPalindrome(String s) {
    	StringBuilder stringBuffer=new StringBuilder();
    	String str1,str2,str3="";
    	for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) { 
				stringBuffer.setLength(0);
				str1=s.substring(i, j+1);           //截取i到j的字符串
				stringBuffer.append(str1);       //加入缓存区
				str2=stringBuffer.reverse().toString();//翻转并转换成字符串
				if (str1.equals(str2)) {          //比较两者是否一样
				//	System.out.println(str3.length());       
					if (str3.length()<str1.length()) {
						str3=str2;                //得到长度最大的子字符串
					}
				
					 
				}
				
			}
		}
        return str3;
       
    }
}
public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
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
