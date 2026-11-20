package Week14_Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Heap_01 {
	// It is a complete binary tree.
	
	// 	Feature 		|		Max Heap 			| 		Min Heap
	// 1. Root			| 	Maximum					|    Minimum
	// 2. Parent		|   Greater					|	 Smaller
	// 3. Used for      |   Largest element			|	 Smallest element
	// 4. Java			| PiorityQueue reverseOrder | PriorityQueue
	
	
	/** 					50
	 					  /	   \
	 					 30	   40
	 					/  \   /  \
	 				   10  20  35 45
	 */
	
	static class MaxHeap{
		ArrayList<Integer>heap = new ArrayList<>();
		
		
		void heapifyUp(int index) {
			while(index > 0) {
				int parent = index - 1/2;
				if(heap.get(index) > heap.get(parent)) {
					Collections.swap(heap, index, parent);
					index = parent;
				}else {
					break;
				}
			}
		}
		
		
		void heapifyDown(int index) {
			int size = heap.size();
			while(true) {
				int largest = index;
				int left = 2*index + 1;
				int right = 2*index + 2;
				if(left<size && heap.get(left)>heap.get(largest)) {
					largest = left;
				}
				
				if(right<size && heap.get(right) > heap.get(largest)) {
					largest = right;
				}
				
				if(largest == index) {
					break;
				}
				
				Collections.swap(heap, index, largest);
				index = largest;
			}
		}
		
		
		void insert(int value) {
			heap.add(value);
			int index = heap.size() - 1;
			heapifyUp(index);
		}
		
		
		int delete() {
			if(heap.size() == 0) {
				throw new NoSuchElementException("Heap is empty");
			}
			
			int maxElement = heap.get(0);
			int last = heap.remove(heap.size() - 1);
			if(!heap.isEmpty()) {
				heap.set(0, last);
				heapifyDown(0);
			}
			
			return maxElement;
		}
		
		
		void printHeap() {
			System.out.println(heap);
		}
	}
	
	
	
	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.insert(50);
		h.insert(30);
		h.insert(40);
		h.insert(10);
		h.insert(20);
		h.insert(35);
		h.insert(25);
		h.printHeap();
		System.out.println(h.delete());
		h.printHeap();
	}
}
