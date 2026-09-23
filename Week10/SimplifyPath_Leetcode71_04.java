package Week10;

import java.util.Stack;

public class SimplifyPath_Leetcode71_04 {
	
	static String simplifyPath(String path) {
        Stack<String>stack = new Stack<>();
        String tokens[] = path.split("/");

        for(int i=0; i<tokens.length; i++){
            String token = tokens[i];
            if(token.equals("") || token.equals(".")){
                continue;
            }else if(token.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(token);
            }
        }

        
        StringBuilder sb = new StringBuilder();
        for(String directory:stack){
            sb.append("/");
            sb.append(directory);
        }

        if(sb.length() == 0){
            return "/";
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		String path = "/home/user/Documents/../Pictures";
		System.out.println(simplifyPath(path));
	}
}
