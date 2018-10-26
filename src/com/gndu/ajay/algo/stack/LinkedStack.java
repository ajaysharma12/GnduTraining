package com.gndu.ajay.algo.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Iterable<E>{
	
	private StackNode<E> first;
	private int size;

	LinkedStack(){
		first = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return first == null; 
	}
	
	public int size(){
		return size;
	}
	
	public void push(E value){
		StackNode<E> oldfirst = first;
		first = new StackNode<E>();
		first.setValue(value);
		first.setNext(oldfirst);
		size++;
	}
	
	public E pop(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		E value = first.getValue();
		first = first.getNext();
		size--;
		return value;
	}
	
	public E peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.getValue();
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		for (E item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
	}
		
	private class ListIterator<Item> implements Iterator<Item>{
		private StackNode<Item> current;
		
		public ListIterator(StackNode<Item> first){
			current = first;
		}
		
		@Override
		public boolean hasNext(){
			return current != null;
		}
		
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
		@Override
		public Item next(){
			if(!hasNext()) throw new NoSuchElementException();
			Item value = current.getValue();
			current = current.getNext();
			return value;
		}		
	}


	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator<E>(first);
	}
}
