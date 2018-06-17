package Week1;

//My implementation.

public class binarySearch {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5, 6};
		System.out.println(search(1, arr));
		
	}
	
	public static int search(int key, int[] arr) {
		int hidex = arr.length - 1;
		int lowdex = 0;
		while (arr[(hidex-lowdex)/2] != key) {
			if (arr[hidex] == key) {
				return hidex;
			} else if (arr[lowdex] == key) {
				return lowdex;
			} else if (hidex == lowdex) {
				return -1;
			} else if (arr[(hidex-lowdex)/2] < key) {
				lowdex = lowdex + (hidex-lowdex)/2;
				System.out.println("lowdex " + lowdex);
				System.out.println("hidex " + hidex);
			} else if (arr[(hidex-lowdex)/2] > key){
				hidex = hidex - (hidex-lowdex)/2;
			}
		}
		return 0;
	}

}
