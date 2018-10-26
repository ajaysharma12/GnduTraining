package com.gndu.ajay.algo.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<E> {
	E data;
	boolean visited;
	List<GraphNode<E>> neighbours;

	GraphNode(E data) {
		this.data = data;
		this.neighbours = new ArrayList<>();
	}

	public void addneighbours(GraphNode<E> neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public List<GraphNode<E>> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<GraphNode<E>> neighbours) {
		this.neighbours = neighbours;
	}
}
