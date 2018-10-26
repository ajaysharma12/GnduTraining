package com.gndu.ajay.algo.graph;

public class GraphTraversalTest {
	public static void main(String arg[]) {

		GraphNode<Integer> node40 = new GraphNode<Integer>(40);
		GraphNode<Integer> node10 = new GraphNode<Integer>(10);
		GraphNode<Integer> node20 = new GraphNode<Integer>(20);
		GraphNode<Integer> node30 = new GraphNode<Integer>(30);
		GraphNode<Integer> node60 = new GraphNode<Integer>(60);
		GraphNode<Integer> node50 = new GraphNode<Integer>(50);
		GraphNode<Integer> node70 = new GraphNode<Integer>(70);

		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);

		IterativeDFS<Integer> iterativeDFS = new IterativeDFS<Integer>();

		System.out.println("The DFS traversal of the graph using stack ");
		iterativeDFS.dfsUsingStack(node40);

		System.out.println();

		// Resetting the visited flag for nodes
		node40.visited = false;
		node10.visited = false;
		node20.visited = false;
		node30.visited = false;
		node60.visited = false;
		node50.visited = false;
		node70.visited = false;

		System.out.println("The DFS traversal of the graph using recursion ");
		RecursiveDFS<Integer> recursiveDFS = new RecursiveDFS<Integer>();
		recursiveDFS.dfs(node40);
	}
}
