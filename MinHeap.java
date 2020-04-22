package leedcode;

import java.util.Arrays;

public class MinHeap {
	private int capacity = 10;
	private int size = 10;
	int [] items = new int[capacity];
	
	private int getParentIndex(int childIndex){
		return (childIndex-1)/2;	
	}
	private int getLeftChildIndex(int parentIndex){
		return 2*parentIndex+1;	
	}
	private int getRightChildIndex(int parentIndex){
		return 2*parentIndex+2;	
	}
	private boolean hasLeftChild(int index){
		return getLeftChildIndex(index)<size;
	}
	private boolean hasRightChild(int index){
		return getRightChildIndex(index)<size;	
	}
	private boolean hasParent(int index){
		return getParentIndex(index)<size;	
	}
	private int leftChild(int index){
		return items[getLeftChildIndex(index)];
	}
	private int rightChild(int index){
		return items[getRightChildIndex(index)];
	}
	private int parent(int index){
		return items[getParentIndex(index)];
	}
	private void swap(int index1,int index2){
		int temp = items[index1];
		items[index1]=items[index2];
		items[index2]=temp;	
	}
	
	private void ensureExtraCapacity(){
		if(size==capacity){
			items = Arrays.copyOf(items, capacity*2);
			capacity=capacity*2;
		}
		
	}
	public int peek() throws Exception{
		if(size==0)throw new Exception();
		return items[0];
	}
	public int poll() throws Exception{
		if(size == 0)throw new Exception();
		int item=items[0];
		items[0]=items[size-1];
		size--;
		bubbleDown();
		return item;				
	}
	
	public void add(int item){
		ensureExtraCapacity();
		items[size]=item;
		size++;
		bubbleUp();
		
	}
	private void bubbleDown() {
		int index = 0;//start the root
		while(hasLeftChild(index)){
			//find smaller child
			int smallChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index)&&rightChild(index)<leftChild(index)){
				smallChildIndex=getRightChildIndex(index);
			}
			if(items[index]<items[smallChildIndex]){
				break;
			}else{
				swap(index,smallChildIndex);
			}
			index=smallChildIndex;//go to  the next level
		}
		
	}
	private void bubbleUp() {
		int index = size-1;
		while(hasParent(index)&&parent(index)>items[index]){
			swap(getParentIndex(index),index);
			index=getParentIndex(index);
		}
		
	}
	}
