package leedcode;
/*
 * Implement a stack
 */
public class Stack {
	private static class Node{
		private int val;
		private Node next;
		private Node(int x){
			this.val=x;
		}
	}
	private Node top;//add and remove here
	public boolean isEmpty(){
		return top==null;
		}
	public int peek(){
		return top.val;
	}
	public void push(int value){
		Node node =new Node(value);
		node.next=top;
		top=node;
		
		
	}
	public int pop(){
		int value=top.val;
		top=top.next;
		return value;
	}
}
