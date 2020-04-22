package leedcode;

import java.awt.List;
import java.util.ArrayList;

public class lesson1 {
	private static ArrayList<String> findMissingRanges(int[] nums ,int lower,int upper){
	ArrayList<String> rst = new ArrayList<String>();
	//step1 记得return返回值
	//step 2 handle candle cases
	if(nums==null||nums.length==0){
		rst.add(lower+"->"+upper);
		return rst;
	}
	//step 3解决最后问题
	//1.
	addToLiad(rst, lower, nums[0]-1);
	//2.
	int prev = nums[0];
	int i =1;
	while(i<nums.length){
		int cur =nums[i];
		if(cur!=prev+1){
			addToLiad(rst, prev+1, cur-1);
		}
		prev=cur;
		i++;
	}
	//3.
	addToLiad(rst, nums[nums.length-1], upper);	
	
	return rst;	
	}
	private static void addToLiad(ArrayList<String> rst,int start,int end){
		if(start == end){
			rst.add(String.valueOf(start));
		}
		else if(start<end){
			rst.add(start+"->"+end);
		}
	}
	public static void main(String[] args){
		int [] nums={0,1,3,50,75};
		int lower = 0;
		int upper = 0;
		ArrayList<String> rst=findMissingRanges(nums,lower,upper);
		System.out.println(rst.toString());
	}
}
