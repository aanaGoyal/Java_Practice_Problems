package Week13_Trees;

public class SumNodesOnLongestPath {
	static class Node {
	    int data;
	    Node left, right;
	    public Node(int data) {
	        this.data = data;

	    }
	} 
	
	
	static class Solution {
	    int maxSum = 0;
	    int maxLength = 0;
	    
	    public void solve(Node root, int length, int sum){
	        if(root == null){
	            return;
	        }
	        
	        length++;
	        sum+=root.data;
	        if(root.left == null && root.right == null){
	            if(maxLength < length){
	                maxLength = length;
	                maxSum = sum;
	            }else if(maxLength == length){
	                maxSum = Math.max(maxSum, sum);
	            }
	            
	            return;
	        }
	        
	        
	        solve(root.left, length, sum);
	        solve(root.right, length, sum);
	    }
	    
	    
	    public int sumOfLongRootToLeafPath(Node root) {
	        if(root == null){
	            return 0;
	        }
	        
	       solve(root, 0,0);
	       return maxSum;
	    }
	}
	
	
	public static void main(String[] args) {
		Solution s1 = new Solution();
		s1.sumOfLongRootToLeafPath(null);
	}
}
