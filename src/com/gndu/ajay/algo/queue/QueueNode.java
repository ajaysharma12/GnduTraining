package com.gndu.ajay.algo.queue;


public class QueueNode<Item> {
	
    private Item value;
    private QueueNode<Item> next;
    
	public Item getValue() {
		return value;
	}
	public void setValue(Item value) {
		this.value = value;
	}
	public QueueNode<Item> getNext() {
		return next;
	}
	public void setNext(QueueNode<Item> next) {
		this.next = next;
	}
  
}
