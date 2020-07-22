/*
Contains BFS and DFS
Uses the adjacent list for the graph representation

*/

//Queue used in BFS
class Queue {
  private items;
  constructor(){ this.items = [];}
  enqueue(...val) {
    this.items = [...this.items, ...val]
  }
  dequeue() {
    return this.items.shift();
  }
  peek() {
    return this.items[0];
  }
  isEmpty() {
    return this.items.length === 0;
  }
}

class Graph {
  
  private noofvertices: Number;
  private adjlist: Map<string, Array<string>>;
  
  constructor(noofverties) {
    this.noofvertices = noofverties;
    this.adjlist = new Map<string, Array<string>>();
  }

  addVertex(v: string){
    this.adjlist.set(v,[])
  }
  // Adding bidirectional link
  addEdge(v: string,w: string) {
    this.adjlist.get(v).push(w);
    this.adjlist.get(w).push(v);
  }

  printGraph() {
     for( const i of Array.from(this.adjlist.keys())) {
      let values = '';
      for(var j of this.adjlist.get(i)) {
        values += j +" ";
      }
      console.log(i + " -> " + values); 
    }
  }

  BFS(startingNode: string) {
    //initially reset the visited list
    let visited = Array.from(this.adjlist.keys());
    for(const i of visited){
      visited[i] = false;
    }

    let q = new Queue();
    visited[startingNode] = true;
    // Start by putting any one of the graph's vertices at the back of a queue.
    // Take the front item of the queue and add it to the visited list.
    q.enqueue(startingNode);
    
    while(!q.isEmpty()){
      const getQueueElement = q.dequeue();
      console.log(getQueueElement);
      this.adjlist.get(getQueueElement).some( neighbour => {
        if (!visited[neighbour]) {
          visited[neighbour] = true;
          q.enqueue(neighbour);
        }
      });
    }
  }

  DFS(startingNode: string) {
    let visited = Array.from(this.adjlist.keys());
    for(const i of visited){
      visited[i] = false;
    }
    this.DFSRecursive(startingNode, visited)
  }
  
  // Uses Recursive for DFS, same can be done using stack
  DFSRecursive(v: string, visited: Array<string>){
    visited[v] = true;
    console.log(v);
    this.adjlist.get(v).some( neighbour => {
      if (!visited[neighbour]) {
            this.DFSRecursive(neighbour, visited);
      }
    });
  }

}

var g = new Graph(6); 
var vertices = [ 'A', 'B', 'C', 'D', 'E', 'F' ]; 
  
// adding vertices 
vertices.some( vertex => g.addVertex(vertex));

// adding edges 
g.addEdge('A', 'B'); 
g.addEdge('A', 'D'); 
g.addEdge('A', 'E'); 
g.addEdge('B', 'C'); 
g.addEdge('D', 'E'); 
g.addEdge('E', 'F'); 
g.addEdge('E', 'C'); 
g.addEdge('C', 'F'); 
  
// prints all vertex and 
// its adjacency list 
// A -> B D E 
// B -> A C 
// C -> B E F 
// D -> A E 
// E -> A D F C 
// F -> E C 
g.printGraph();
console.log("----DFS----");
g.DFS('A');
// prints DFS
// A B C E D F 
console.log("----BFS----");
g.BFS('A');
// prints BFS
// A B D E C F
