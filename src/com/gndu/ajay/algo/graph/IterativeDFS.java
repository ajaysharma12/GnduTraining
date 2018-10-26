package com.gndu.ajay.algo.graph;

import java.util.List;
import java.util.Stack;

//
//    40----->20------->50
//     |    /  | \        \\ >
//     |   /   |  \            70
//    <| </   <|   \>     //>
//    10------>30------>60
//
public class IterativeDFS<E> {
	// Iterative DFS using stack
	public  void dfsUsingStack(GraphNode<E> node)
		{
			Stack<GraphNode<E>> stack=new  Stack<GraphNode<E>>();
			stack.add(node);
			node.visited=true;
			while (!stack.isEmpty())
			{
				GraphNode<E> element=stack.pop();
				System.out.print(element.data + " ");
	 
				List<GraphNode<E>> neighbours=element.getNeighbours();
				for (int i = 0; i < neighbours.size(); i++) {
					GraphNode<E> n=neighbours.get(i);
					if(n!=null && !n.visited)
					{
						stack.add(n);
						n.visited=true;
	 
					}
				}
			}
		}
}
