package percolation;
import java.util.Random;

public class PercolationStats {
	
	public Percolation perc;
	private int length;
	public int openSites;
	public double[] trialRatios;
	
	public PercolationStats(int n, int trials) {
		length = n;
		trialRatios = new double[trials]; 
		while (trials > 0) {
			perc = new Percolation(n);
			openSites = 0;
			while (!perc.percolates()) {
				openRandom();
			}
			trialRatios[trials-1] = (double) openSites / (n*n);
			trials -= 1;
		}
	}
	
	public void printTrialRatios() {
		for (int i = 0; i < trialRatios.length; i++) {
			System.out.print(trialRatios[i] + " ");
		}
	}
	
	public int[] openRandom() {
		Random ayn = new Random();
		int randomRow = ayn.nextInt(length);
		int randomCol = ayn.nextInt(length);
		if (perc.open(randomRow, randomCol)) openSites += 1;
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
