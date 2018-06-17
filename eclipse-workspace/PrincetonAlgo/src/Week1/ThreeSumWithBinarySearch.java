package Week1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSumWithBinarySearch {

	public static int ThreeSum(int[] a) {
		//Two nested loops to get the first two in the triple.
		int count = 0;
		int n = a.length;
		Arrays.sort(a);
		for (int i=0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				//Use binary search to find all values a[k] such that (a[i]+ a[j]) + a[k] = 0
				int k = Arrays.binarySearch(a, -(a[i]+a[j]));
				if (k > j) { count++; }
			}
		}
		return count;
	}
	
	public static int BinarySearch(int[] a, int key) {
		int hi = a.length - 1, lo = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key == a[mid]) return mid;
			else if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] a = in.readAllInts();
		
		Stopwatch timer = new Stopwatch();
		int count = ThreeSum(a);
		StdOut.println("elapsed time = " + timer.elapsedTime());
		StdOut.println(count);
		
	}
	
}
