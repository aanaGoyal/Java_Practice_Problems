package Week13_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBT_05 {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	static boolean isCompleteBT(Node root) {
		if(root == null) {
			return true;
		}
		
		Queue<Node>queue = new LinkedList<>();
		queue.add(root);
		
		boolean nullFound = false;
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if(currentNode == null) {
				nullFound = true;
			}else {
				if(nullFound) {
					return false;
				}
				
				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(50);
		root.left.right = new Node(60);
		
		root.right.left = new Node(70);
		root.right.right = new Node(80);
		
		System.out.println("Is Complete BT: " + isCompleteBT(root));
	}
}
