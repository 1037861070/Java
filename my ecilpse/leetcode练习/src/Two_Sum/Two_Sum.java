package Two_Sum;


public class Two_Sum {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		int nums[]={11,3,2,7},target=9;
		int a[]=new int[2];
         a=new Solution().twoSum(nums, target);
         System.out.println("结果为："+a[0]+","+a[1]);
	}

}
