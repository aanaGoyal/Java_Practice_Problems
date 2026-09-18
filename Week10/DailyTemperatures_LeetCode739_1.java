package Week10;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures_LeetCode739_1 {
	
	static int[] dailyTemperatures(int temperatures[]) {
		Stack<Integer>st = new Stack<>();
        int arr[] = new int[temperatures.length];
        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int index = st.pop();
                arr[index] = i - index;
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int index = st.pop();
            arr[index] = 0;
        }

        return arr;
	}
	
	
	public static void main(String[] args) {
		int arr[] = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.asList(dailyTemperatures(arr)));
	}
}
