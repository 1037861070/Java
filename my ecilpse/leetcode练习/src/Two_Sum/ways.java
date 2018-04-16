package Two_Sum;

public class ways {

}
class Solution {
	public Solution() {
		// TODO 自动生成的构造函数存根
	}
	public int[] twoSum(int[] nums, int target) {
        int i,j,sum;
        int []arr=new int[2] ;
        for(i=0;i<nums.length;i++)
            for(j=i+1;j<nums.length;j++)
            {
            	sum=nums[i]+nums[j];
            	if (sum==target) {
					arr[0]=i;
					arr[1]=j;
				}	
            }
      return arr;   
    }
}