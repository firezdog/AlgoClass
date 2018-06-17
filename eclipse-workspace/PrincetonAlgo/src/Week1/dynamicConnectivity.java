package Week1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class dynamicConnectivity {

    static int[] nodes;
    int count;

    public dynamicConnectivity(int n){
        count = n;
        nodes = new int[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }
    
    public int count() {
    	return count;
    }
    
    public static void main(String[] args){
        In in = new In(args[0]);
    	int n = in.readInt();
        dynamicConnectivity dc = new dynamicConnectivity(n);
        while (!in.isEmpty()){
            int a = in.readInt();
            int b = in.readInt();
            dc.connect(a,b);
        }
        StdOut.println("Total components: " + dc.count());
    }

    public boolean connect(int a, int b) {
        if (isConnected(a, b)) return false;
        int toConnect = nodes[a];
        int connectTo = nodes[b];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == toConnect) nodes[i] = connectTo;
        }

        count--;
        // StdOut.println(isConnected(a, b));
        // StdOut.println(this.count());
        return true;
    }

    public boolean isConnected(int a, int b) {
        return nodes[a] == nodes[b];
    }

}