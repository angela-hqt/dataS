package leedcode;

import java.util.HashMap;
import java.util.Map;

/**
*Given an array of integers，return indices of the two numbers
*sum that they add up to a specific target.
*You may assume that there is no duplicate number in the array and
*each input would have exactly one solution，
*and you may not use the same element twice.
*E.g.
*Given nums =[2，7，11，15]，target=9，
return（0，1）.
*/
	//1.暴力解法 O(n^2)
	//2.优化 O(n)
	//思路-array存入hashmap里
/*key  value
 *2 	0
 *7		1
 *11	2
 *15	3
 */
	//3.先get再put会更便捷
public class TwoSum {
	private static int [] twoSum (int[] numbers, int target){
		//define return value
		int [] indexArray = new int [2];
		//handle corner cases
		if(numbers==null||numbers.length==0){
			return null;
		}
		//Value<->index map
		Map<Integer,Integer>hashmap = new HashMap<>();
		for(int i=0;i<numbers.length;i++){
			hashmap.put(numbers[i], i);
		}
		for(int i=0;i<numbers.length;i++){
			if(hashmap.containsKey(target - numbers[i])){
				indexArray[0]=i;
				indexArray[1]=hashmap.get(target - numbers[i]);
			}
			if(indexArray[0]==indexArray[1])
				continue;
			return indexArray;
		}
			return null;
	}
	
	
}
