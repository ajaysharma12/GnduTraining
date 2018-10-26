package com.gndu.ajay.algo.linkedlist.single;

import java.util.Scanner;

public class SinglyLinkedListTest {
	public static void main(String a[]) {
		testSinglyLinkedList();
		testCircularSinglyLinkedList();
	}
	
	private static void testSinglyLinkedList(){
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(3);
		sll.add(32);
		sll.add(54);
		sll.add(89);
		sll.add(82);
		sll.add(85);
		sll.addAfter(76, 54);
		sll.deleteFront();
		sll.deleteAfter(76);
		sll.traverse();
	}
	
	
	private static void testCircularSinglyLinkedList(){
		{            
	        Scanner scan = new Scanner(System.in);
	        /* Creating object of linkedList */
	        CircularSinglyLinkedList<Integer> circularSLL = new CircularSinglyLinkedList<Integer>(); 
	        System.out.println("Circular Singly Linked List Test\n");          
	        char ch;
	        /*  Perform list operations  */
	        do
	        {
	            System.out.println("\nCircular Singly Linked List Operations\n");
	            System.out.println("1. insert at begining");
	            System.out.println("2. insert at end");
	            System.out.println("3. insert at position");
	            System.out.println("4. delete at position");
	            System.out.println("5. check empty");
	            System.out.println("6. get size");            
	            int choice = scan.nextInt();            
	            switch (choice)
	            {
	            case 1 : 
	                System.out.println("Enter integer element to insert");
	                circularSLL.insertAtStart( scan.nextInt() );                     
	                break;                          
	            case 2 : 
	                System.out.println("Enter integer element to insert");
	                circularSLL.insertAtEnd( scan.nextInt() );                     
	                break;                         
	            case 3 : 
	                System.out.println("Enter integer element to insert");
	                int num = scan.nextInt() ;
	                System.out.println("Enter position");
	                int pos = scan.nextInt() ;
	                if (pos <= 1 || pos > circularSLL.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                	circularSLL.insertAtPos(num, pos);
	                break;                                          
	            case 4 : 
	                System.out.println("Enter position");
	                int p = scan.nextInt() ;
	                if (p < 1 || p > circularSLL.getSize() )
	                    System.out.println("Invalid position\n");
	                else
	                	circularSLL.deleteAtPos(p);
	                break;
	            case 5 : 
	                System.out.println("Empty status = "+ circularSLL.isEmpty());
	                break;                   
	            case 6 : 
	                System.out.println("Size = "+ circularSLL.getSize() +" \n");
	                break;                         
	             default : 
	                System.out.println("Wrong Entry \n ");
	                break;   
	            }
	            /*  Display List  */ 
	            circularSLL.display();
	            System.out.println("\nDo you want to continue (Type y or n) \n");
	            ch = scan.next().charAt(0);            
	        } while (ch == 'Y'|| ch == 'y');         
	        scan.close();
	    } 
	}
}
