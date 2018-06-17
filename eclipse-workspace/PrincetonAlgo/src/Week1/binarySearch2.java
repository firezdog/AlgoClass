package Week1;

//The correct / clean implementation.

public class binarySearch2 {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,4,5,6,7};
		System.out.println(binarySearch(a, 4));

	}
	
	public static int binarySearch(int[] a, int key) {
		int lo = 0, hi = a.length-1;
		while (lo <= hi) { 
			int mid = lo + (hi-lo) / 2;
			if (key < a[mid]) hi = mid -1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}

}
