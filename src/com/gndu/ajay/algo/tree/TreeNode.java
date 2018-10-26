package com.gndu.ajay.algo.tree;

public class TreeNode<E> {
	private E value;
	private TreeNode<E> left;
	private TreeNode<E> right;

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	TreeNode(E value) {
		this.value = value;
		right = null;
		left = null;
	}

	public String toString() {
		return value.toString() + " ";
	}
}
