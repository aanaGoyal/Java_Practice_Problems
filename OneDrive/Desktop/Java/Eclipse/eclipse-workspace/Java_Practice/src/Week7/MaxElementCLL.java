package Week7;

public class MaxElementCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static int findMax(Node head) {
        int max = head.data;
        Node temp = head.next;
        while (temp != head) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    public static void main(String[] args) {
        Node head = new Node(15);
        head.next = new Node(40);
        head.next.next = new Node(25);
        head.next.next.next = head; // make circular

        System.out.println("Maximum element: " + findMax(head));
    }
}
