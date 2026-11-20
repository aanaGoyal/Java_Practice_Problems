package Week14_Trees;

public class MaximumPathSumWithOneTurn {
	static class Node {
        long val;
        Node left, right;

        Node(long val) {
            this.val = val;
        }
    }
	
	
	static long maxDownwardSum(Node root) {
        if (root == null) {
            return 0;
        }

        long left = maxDownwardSum(root.left);
        long right = maxDownwardSum(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
	
	
	static long maxPathSum(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return Long.MIN_VALUE;
        }

        long leftSum = maxDownwardSum(root.left);
        long rightSum = maxDownwardSum(root.right);
        return root.val + leftSum + rightSum;
    }
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		System.out.println(maxPathSum(root));
		
		
		// Explanation:
		// Since, we want that path must start from left subtree and end in right subtree and pass through parent node, 
		// we can find the max sum from left subtree and then right subtree and add them with the root.
	}
	
}
