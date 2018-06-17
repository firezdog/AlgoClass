class connectedNodes {
    constructor(n) {
        this.nodes = [];
        this.size = []
        for (let i = 0; i < n; i++) {
            this.nodes[i] = i;
            this.size[i] = 1;
        }
    }
    root(a) {
        let aRoot = a;
        while (aRoot != this.nodes[aRoot]) {
            this.nodes[aRoot] = this.nodes[this.nodes[aRoot]];
            aRoot = this.nodes[aRoot];
        }
        return aRoot;
    }
    connect(a, b) {
        let aRoot = this.root(a)
        let bRoot = this.root(b)
        if(this.size[aRoot] < this.size[bRoot]){
            this.nodes[aRoot] = bRoot
            this.size[bRoot] += this.size[aRoot];
        } else {
            this.nodes[bRoot] = aRoot;
            this.size[aRoot] += this.size[bRoot];
        }
        return this;
    }
    connected(a, b) {
        let aRoot = this.root(a);
        let bRoot = this.root(b);
        return aRoot == bRoot ? true : false;
    }
}

let sample = new connectedNodes(10);
sample.connect(4,3).connect(3,8).connect(6,5).connect(9,4).connect(2,1).connect(5,0).connect(7,2).connect(6,1).connect(7,3);