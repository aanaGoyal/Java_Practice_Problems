package Week13_Trees;

import Week13_Trees.LevelOrderTraversal_02.Node;

public class CountNodes_03 {
	
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
	
	static int countNodes(Node root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(50);
		root.left.right = new Node(60);
		
		root.right.left = new Node(70);
		root.right.right = new Node(80);
		
		System.out.println("Count Nodes: " + countNodes(root));
	}
}
