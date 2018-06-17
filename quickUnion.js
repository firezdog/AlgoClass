//Like quickUnion2, but uses a hash to keep track of tree size (could detract from performance gains?)

class connectedNodes {
    constructor(n){
        this.nodes = [];
        for (let i=0; i < n; i++){
            this.nodes[i] = i;
        }
    }
    root(a){
        let aRoot = a;
        let count = 1;
        while (aRoot != this.nodes[aRoot]) { 
            aRoot = this.nodes[aRoot]; 
            count++;
        }
        return {root: aRoot, count: count}
    }
    connect(a,b){
        let aRoot = this.root(a)
        let bRoot = this.root(b)
        bRoot.count < aRoot.count ? 
            this.nodes[bRoot.root] = aRoot.root :
            this.nodes[aRoot.root] = bRoot.root;
        return this;
    }
    connected(a,b){
        let aRoot = this.root(a).root;
        let bRoot = this.root(b).root;
        return aRoot == bRoot ? true : false;
    }
}