package percolation;

import java.util.Random;

public class PercolationStats {
	
	public Percolation perc;
	private int length;
	
	public PercolationStats(int n, int trials) {
		length = n;
		perc = new Percolation(n);
	}
	
	public int[] openRandom() {
		Random ayn = new Random();
		int randomRow = ayn.nextInt(length);
		int randomCol = ayn.nextInt(length);
		perc.open(randomRow, randomCol);
		return new int[] {randomRow, randomCol};
	}
	
//	public double mean() {
//		
//	}
//	
//	public double stddev() {
//		
//	}
//	
//	public double confidenceLo() {
//		
//	}
//	
//	public double confidenceHi() {
//		
//	}
//	
//	public static void main(String[] args) {
//
//	}

}
