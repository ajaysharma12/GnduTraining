package com.gndu.ajay.algo.graph;

import java.util.List;

public class RecursiveDFS<E> {
	// Recursive DFS
	public void dfs(GraphNode<E> node) {
		System.out.print(node.data + " ");
		List<GraphNode<E>> neighbours = node.getNeighbours();
		node.visited = true;
		for (int i = 0; i < neighbours.size(); i++) {
			GraphNode<E> n = neighbours.get(i);
			if (n != null && !n.visited) {
				dfs(n);
			}
		}
	}
}
