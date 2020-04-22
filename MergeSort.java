package leedcode;

public class MergeSort {
	public static void sort(int[] array){
		mergesort(array,new int[array.length],0,array.length-1);
	}

	public static void mergesort(int[] array, int[] temp, int leftStart, int rightEnd) {
		if(leftStart>=rightEnd){
			return;
		}
		int middle=(leftStart+rightEnd)/2;
		mergesort(array,temp,leftStart,middle);
		mergesort(array,temp,middle+1,rightEnd);
		mergeHalves(array,temp,leftStart,rightEnd);
		
	}
	public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
		int leftEnd=(rightEnd+leftStart)/2;
		int rightStart=leftEnd+1;
		int size=rightEnd-leftStart+1;
		int left=leftStart;
		int right=rightStart;
		int index=leftStart;
		//将分开的两个数组排序，left1和right1比较
		//超出范围跳出left/right，最后会剩下1个，还要copy下来
		while(left<=leftEnd&&right<=rightEnd){
			if(array[left]<=array[right]){
				temp[index]=array[left];
				left++;
			}
			else{
				temp[index]=array[right];
				right++;
			}
			index++;
		}
		//这两行只有一行会用，零一行为0
		//array的东西传到temp里面，array的第一个left，temp第一个index，有leftEnd-left +1个值
		System.arraycopy(array, left, temp, index, leftEnd-left +1);
		System.arraycopy(array, right, temp, index, rightEnd -right +1);
		
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
	}
}
