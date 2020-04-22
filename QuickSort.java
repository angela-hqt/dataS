package leedcode;

public class QuickSort {
		public static void sort(int [] array){
			quicksort(array,0,array.length-1);
		}

		private static void quicksort(int[] array, int left, int right) {
			if(left>=right){
				return;
			}
			int pivot = array[(left+right)/2];
			int index = partition(array,left,right,pivot);
			quicksort(array,left,index-1);
			quicksort(array,index,right);
			
		}

		private static int partition(int[] array, int left, int right, int pivot) {
			while(left<=right){
				//找到一个数比标准的数大，左指针开始
				while(array[left]<pivot){
					left++;
				}
				while(array[right]>pivot){
					right--;
				}
				if(left<=right){
					swap(array,left,right);
					left++;
					right--;
				}
				
			}
			return left;
		}

		private static void swap(int[] array, int left, int right) {
			int temp=array[left];
			array[left]=array[right];
			array[right]=temp;
			
		}
}
