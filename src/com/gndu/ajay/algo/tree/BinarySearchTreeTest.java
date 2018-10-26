package com.gndu.ajay.algo.tree;

public class BinarySearchTreeTest {
	public static void main(String arg[]) {
		testBinarySearchTree();
		testRecursiveBinarySearchTree();
	}

	private static void testBinarySearchTree() {
		BinarySearchTree<Integer> b = new BinarySearchTree<Integer>();
		b.insert(3);
		b.insert(8);
		b.insert(1);
		b.insert(4);
		b.insert(6);
		b.insert(2);
		b.insert(10);
		b.insert(9);
		b.insert(20);
		b.insert(25);
		b.insert(15);
		b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));
		b.display(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
		b.display(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
		b.display(b.root);
	}
	
	private static void testRecursiveBinarySearchTree(){
		RecursiveBinarySearchTree<Integer> bsTree = new RecursiveBinarySearchTree<Integer>(); 
		  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
        20   40  60   80 */
		
		bsTree.add(50);
		bsTree.add(30);
		bsTree.add(20);
		bsTree.add(40);
		bsTree.add(70);
		bsTree.add(60);
		bsTree.add(80);
		
        System.out.println("Inorder traversal of the given tree"); 
        bsTree.traverseInOrder(bsTree.root); 
  
        System.out.println("\nDelete 20"); 
        bsTree.delete(20);
        System.out.println("Inorder traversal of the modified tree"); 
        bsTree.traverseInOrder(bsTree.root); 
  
        System.out.println("\nDelete 30"); 
        bsTree.delete(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        bsTree.traverseInOrder(bsTree.root); 
  
        System.out.println("\nDelete 50"); 
        bsTree.delete(50);
        System.out.println("Inorder traversal of the modified tree"); 
        bsTree.traverseInOrder(bsTree.root);  
	}
}
