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
		//���ֿ���������������left1��right1�Ƚ�
		//������Χ����left/right������ʣ��1������Ҫcopy����
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
		//������ֻ��һ�л��ã���һ��Ϊ0
		//array�Ķ�������temp���棬array�ĵ�һ��left��temp��һ��index����leftEnd-left +1��ֵ
		System.arraycopy(array, left, temp, index, leftEnd-left +1);
		System.arraycopy(array, right, temp, index, rightEnd -right +1);
		
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
	}
}
