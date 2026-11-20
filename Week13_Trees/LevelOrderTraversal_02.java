package Week13_Trees;

import java.util.LinkedList;
import java.util.Queue;

import Week13_Trees.CreateBinaryTree_01.Node;

public class LevelOrderTraversal_02 {
	
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
	
	
	static void printTree(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node>queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			System.out.print(currentNode.data + " ");
			
			if(currentNode.left != null) {
				queue.add(currentNode.left);
			}
			
			if(currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(50);
		root.left.right = new Node(60);
		
		root.right.left = new Node(70);
		root.right.right = new Node(80);
		
		printTree(root);
	}
}
