package Week13_Trees;

public class CreateBinaryTree_01 {
	
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
	
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		
		root.left.left = new Node(50);
		root.left.right = new Node(60);
		
		root.right.left = new Node(70);
		root.right.right = new Node(80);
	}
}
