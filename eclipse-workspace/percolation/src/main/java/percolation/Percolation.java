package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int[][] grid;
	private WeightedQuickUnionUF qu;
	private int n;
	
	public Percolation(int n) {
		this.n = n;
		grid = new int[n][n];
		qu = new WeightedQuickUnionUF(n*n);
		for (int i=0; i < n-1; i++) {
			qu.union(i, i+1);
			qu.union((n*(n-1))+i,(n*(n-1))+i+1);
		}
	}
	
	public boolean percolates(int row, int col) {
		return isConnected(row,col,n-1,n-1);
	}
	
	public boolean isFull(int row, int col) {
		return isConnected(row, col, 0, 0);
	}
	
	public int entryToInt(int row, int col) {
		return row*n + col;
	}
	
	public boolean isConnected(int row1, int col1, int row2, int col2) {
		int node1 = entryToInt(row1, col1);
		int node2 = entryToInt(row2, col2);
		return qu.connected(node1, node2);
	}
	
	public void connect(int row1, int col1, int row2, int col2) {
		int node1 = entryToInt(row1, col1);
		int node2 = entryToInt(row2, col2);
		qu.union(node1, node2);
	}
	
	public void open(int row, int col) {
		grid[row][col] = 1;
		if (checkUp(row, col)) connect(row,col,row-1,col); 
		if (checkDown(row, col)) connect(row,col,row+1,col); 
		if (checkLeft(row, col)) connect(row,col,row,col-1); 
		if (checkDown(row, col)) connect(row,col,row,col+1); 
	}
	
	//begin isOpen and subordinate methods.
	public boolean isOpen(int row, int col) {
		return grid[row][col] == 1;
	}
	
	public boolean checkLeft(int row, int col) {
		if (col == 0) return false;
		return isOpen(row, col-1);
	}
	
	public boolean checkRight(int row, int col) {
		if (col == n-1) return false;
		return isOpen(row, col+1);
	}
	
	public boolean checkUp(int row, int col) {
		if (row == 0) return false;
		return isOpen(row-1, col);
	}
	
	public boolean checkDown(int row, int col) {
		if (row == n-1) return false;
		return isOpen(row+1, col);
	}
	//end isOpen and subordinate methods.
	
	public void printGrid() {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				System.out.print(grid[row][col] + " ");
			}
			System.out.println();
		}
	}
	
}