package com.gndu.ajay.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RecursiveBinarySearchTree<E extends Comparable<E>> {
	TreeNode<E> root;

	// This method mainly calls insertRec() 
    public void add(E key) 
    { 
        root = addRecursive(root, key); 
    } 
    
	private TreeNode<E> addRecursive(TreeNode<E> current, E insertEntity) {
		if (current == null) {
			return new TreeNode<E>(insertEntity);
		}
		if (insertEntity.compareTo(current.getValue()) < 0) {
			current.setLeft(addRecursive(current.getLeft(), insertEntity));
		} else if (insertEntity.compareTo(current.getValue()) > 0) {
			current.setRight(addRecursive(current.getRight(), insertEntity));
		} else {
			// value already exists
			return current;
		}
		return current;
	}

	public boolean find(TreeNode<E> current, E findEntity) {
		if (current == null) {
			return false;
		}

		if (findEntity.equals(current.getValue())) {
			return true;
		}
		return findEntity.compareTo(current.getValue()) < 0 ? find(current.getLeft(), findEntity)
				: find(current.getRight(), findEntity);
	}

	// This method mainly calls deleteRec() 
    public void delete(E key) 
    { 
        root = deleteRecursive(root, key); 
    }
	
	private TreeNode<E> deleteRecursive(TreeNode<E> current, E deleteEntity) {
		if (current == null) {
			return current;
		}
		if (deleteEntity.compareTo(current.getValue()) < 0) {
			current.setLeft(deleteRecursive(current.getLeft(), deleteEntity));
		} else if (deleteEntity.compareTo(current.getValue()) > 0){
			current.setRight(deleteRecursive(current.getRight(), deleteEntity));
		}
		// Node to delete found
		else if (deleteEntity.compareTo(current.getValue()) == 0) {	
			// ... code to delete the node will go here
			// Node with only one children
			if (current.getLeft() == null) 
                return current.getRight(); 
            else if (current.getRight() == null) 
                return current.getLeft(); 
			
			// node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
			current.setValue(findSmallestValue(current.getRight()));
			
			// Delete the inorder successor 
			current.setRight(deleteRecursive(current.getRight(), current.getValue()));
		}
		return current;	
	}

	public void traverseInOrder(TreeNode<E> node) {
		if (node != null) {
			traverseInOrder(node.getLeft());
			System.out.print(" " + node.getValue());
			traverseInOrder(node.getRight());
		}
	}

	public void traversePreOrder(TreeNode<E> node) {
		if (node != null) {
			System.out.print(" " + node.getValue());
			traversePreOrder(node.getLeft());
			traversePreOrder(node.getRight());
		}
	}

	public void traversePostOrder(TreeNode<E> node) {
		if (node != null) {
			traversePostOrder(node.getLeft());
			traversePostOrder(node.getRight());
			System.out.print(" " + node.getValue());
		}
	}

	public void traverseLevelOrder(TreeNode<E> node) {
		if (node == null) {
			return;
		}

		Queue<TreeNode<E>> queueTreeNodes = new LinkedList<TreeNode<E>>();
		queueTreeNodes.add(node);

		while (!queueTreeNodes.isEmpty()) {

			TreeNode<E> treeNode = queueTreeNodes.remove();

			System.out.print(" " + treeNode.getValue());

			if (node.getLeft() != null) {
				queueTreeNodes.add(node.getLeft());
			}

			if (node.getRight() != null) {
				queueTreeNodes.add(node.getRight());
			}
		}
	}

	public E findSmallestValue(TreeNode<E> root) {
		return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
	}
	
	// Returns true if tree with given root contains 
	// dead end or not. min and max indicate range 
	// of allowed values for current node. Initially 
	// these values are full range. 
//	boolean deadEnd(TreeNode<E> root, int min, int max) 
//	{ 
//	    // if the root is null or the recursion moves 
//	    // after leaf node it will return false 
//	    // i.e no dead end. 
//	    if (root==null) 
//	        return false; 
//	  
//	    // if this occurs means dead end is present. 
//	    if (min == max) 
//	        return true; 
//	  
//	    // heart of the recursion lies here. 
//	    return deadEnd(root.getLeft(), min, root.getValue() - 1) || deadEnd(root.getRight(), root.data + 1, max); 
//	} 
	
}
