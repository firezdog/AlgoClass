package percolation;
import java.util.Random;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
	
	public Percolation perc;
	private int length;
	public int openSites;
	public double[] trialRatios;
	
	public PercolationStats(int n, int trials) {
		int originalTrials = trials;
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
		System.out.println("Mean ratio: " + mean(trialRatios));
		System.out.println("Standard deviation: " + stddev(trialRatios));
		System.out.println("Lower confidence interval: " + confidenceLo(trialRatios, originalTrials));
		System.out.println("Upper confidence interval: " + confidenceHi(trialRatios, originalTrials));
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
	
	public double mean(double[] trialRatios) {
		return StdStats.mean(trialRatios);
	}
	
	public double stddev(double[] trialRatios) {
		return StdStats.stddev(trialRatios);
	}
	
	public double confidenceLo(double[] trialRatios, int trials) {
		double x_bar = mean(trialRatios);
		double s = stddev(trialRatios);
		double root_t = Math.sqrt((double) trials);
		return x_bar - ((1.96) * s / root_t);
	}
	
	public double confidenceHi(double[] trialRatios, int trials) {
		double x_bar = mean(trialRatios);
		double s = stddev(trialRatios);
		double root_t = Math.sqrt((double) trials);
		return x_bar + ((1.96) * s / root_t);
	}
	
	public static void main(String[] args) {
		int n = (int) Integer.parseInt(args[0]);
		int T = (int) Integer.parseInt(args[1]);
		Stopwatch s = new Stopwatch();
		PercolationStats percstats = new PercolationStats(n,T);
		System.out.println("Running time: " + s.elapsedTime() + "s");
	}

}
