class connectedNodes {
    constructor(n){
        this.nodes = [];
        for (let i=0; i<n; i++){
            this.nodes[i] = i;
        }
    }
    connect(a,b){
        let idA = this.nodes[a];
        let idB = this.nodes[b];
        for (let i=0; i<this.nodes.length;i++){
            this.nodes[i] === idB ? this.nodes[i] = idA : null;
        }
        return this;
    }
    connected(a,b){
        return this.nodes[a] == this.nodes[b] ? true : false;
    }
}