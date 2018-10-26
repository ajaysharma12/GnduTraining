package com.gndu.ajay.algo.tree;

public class BinarySearchTree<E extends Comparable<E>> {
	public TreeNode<E> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public boolean find(E searchEntity) {
		TreeNode<E> current = root;
		while (current != null) {
			if (current.getValue().equals(searchEntity)) {
				return true;
			} else if (searchEntity.compareTo(current.getValue()) < 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return false;
	}

	public boolean delete(E deleteEntity) {
		TreeNode<E> parent = root;
		TreeNode<E> current = root;
		boolean isLeftChild = false;
		while (current.getValue().equals(deleteEntity)) {
			parent = current;
			if (deleteEntity.compareTo(current.getValue()) < 0) {
				isLeftChild = true;
				current = current.getLeft();
			} else {
				isLeftChild = false;
				current = current.getRight();
			}
			if (current == null) {
				return false;
			}
		}
		// if i am here that means we have found the node
		// Case 1: if node to be deleted has no children
		if (current.getLeft() == null && current.getRight() == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.setLeft(null);
			} else {
				parent.setRight(null);
			}
		}
		// Case 2 : if node to be deleted has only one child
		else if (current.getRight() == null) {
			if (current == root) {
				root = current.getLeft();
			} else if (isLeftChild) {
				parent.setLeft(current.getLeft());
			} else {
				parent.setRight(current.getLeft());
			}
		} else if (current.getLeft() == null) {
			if (current == root) {
				root = current.getRight();
			} else if (isLeftChild) {
				parent.setLeft(current.getRight());
			} else {
				parent.setRight(current.getRight());
			}
		} else if (current.getLeft() != null && current.getRight() != null) {

			// now we have found the minimum element in the right sub tree
			TreeNode<E> successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.setLeft(successor);
			} else {
				parent.setRight(successor);
			}
			successor.setLeft(current.getLeft());
		}
		return true;
	}

	public TreeNode<E> getSuccessor(TreeNode<E> deleteNode){
		TreeNode<E> successsor =null;
		TreeNode<E> successsorParent =null;
		TreeNode<E> current = deleteNode.getRight();
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.getLeft();
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleteNode.getRight()){
			successsorParent.setLeft(successsor.getRight());
			successsor.setRight(deleteNode.getRight());
		}
		return successsor;
	}
	
	public void insert(E insertEntity){
		TreeNode<E> newNode = new TreeNode<E>(insertEntity);
		if(root==null){
			root = newNode;
			return;
		}
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		while(true){
			parent = current;
			
			if(insertEntity.compareTo(current.getValue()) < 0){				
				current = current.getLeft();
				if(current==null){
					parent.setLeft(newNode);
					return;
				}
			}else{
				current = current.getRight();
				if(current==null){
					parent.setRight(newNode);
					return;
				}
			}
		}
	}
	
	public void add(E value) {
		TreeNode<E> newNode = new TreeNode<E>(value);
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode<E> current = root;
		TreeNode<E> parent = null;
		while (true) {
			parent = current;
			if (value.compareTo(current.getValue()) < 0) {
				current = current.getLeft();
				if (current == null) {
					parent.setLeft(newNode);
					return;
				}
			} else if (value.compareTo(current.getValue()) > 0) {
				current = current.getRight();
				if (current == null) {
					parent.setRight(newNode);
					return;
				}
			} else {
				return;
			}
		}
	}

	public void display(TreeNode<E> root) {
		if (root != null) {
			display(root.getLeft());
			System.out.print(" " + root.getValue());
			display(root.getRight());
		}
	}
}
