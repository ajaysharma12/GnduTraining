package com.gndu.ajay.algo.linkedlist.doubly;

import java.util.Scanner;

public class LinkedListTest {

	public static void main(String a[]) {
		testDoublyLinkedList();
		testCircularDoubleLinkedList();
	}
	
	private static void testDoublyLinkedList(){
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addLast(56);
		dll.addLast(364);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
	}
	
	private static void testCircularDoubleLinkedList(){
		Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
		CircularDoubleLinkedList<Integer> circulardll = new CircularDoubleLinkedList<Integer>(); 
        System.out.println("Circular Doubly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do    
        {
            System.out.println("\nCircular Doubly Linked List Operations\n");
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
                circulardll.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                circulardll.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos < 1 || pos > circulardll.getSize() )
                    System.out.println("Invalid position\n");
                else
                	circulardll.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > circulardll.getSize() )
                    System.out.println("Invalid position\n");
                else
                	circulardll.deleteAtPos(p);
                break;     
            case 5 : 
                System.out.println("Empty status = "+ circulardll.isEmpty());
                break;            
            case 6 : 
                System.out.println("Size = "+ circulardll.getSize() +" \n");
                break;                         
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            circulardll.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');    
        scan.close();
	}
}
