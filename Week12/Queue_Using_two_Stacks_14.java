package Week12;

import java.util.Stack;

public class Queue_Using_two_Stacks_14 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void ENQUEUE(int x) {
        s1.push(x);
    }

    void DEQUEUE() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        System.out.println(s2.pop());
    }

    void FRONT() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("EMPTY");
            return;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        System.out.println(s2.peek());
    }

    public static void main(String[] args) {
        Queue_Using_two_Stacks_14 q1 = new Queue_Using_two_Stacks_14();

        q1.ENQUEUE(5);
        q1.ENQUEUE(12);
        q1.ENQUEUE(19);
        q1.FRONT();
        q1.DEQUEUE();
        q1.ENQUEUE(19);
        q1.DEQUEUE();
        q1.DEQUEUE();
    }
}