package leedcode;
/*查找10次提交中是那一次出现bug
 * E.G
 * 1 2 3 4 5 6 7 8 9 10
 * G G G B B B B B B B
 */
public class FindBadVersion {
	private static int FIRST_BAD = 4;
	private static boolean isBadVersion(int version){
		if(version>=FIRST_BAD){
			return true;
		}
		return false;
	}
	private static int firstBadVersion(int n){
		int low =1;
		int high=n;
		while(low<high){
			int mid=low+(high-low)/2;
			if(isBadVersion(mid)){
			high=mid;}
			else{
				low=mid+1;
			}
		}
		return low;
	}
	public static void main(String[] args){
		int rst =firstBadVersion(10);
		System.out.println(rst);
	}
			
}
