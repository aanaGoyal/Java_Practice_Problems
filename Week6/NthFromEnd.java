package Week6;

public class NthFromEnd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static int findNthFromEnd(Node head, int n) {
        Node fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return -1; // n is greater than list length
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;
        System.out.println(n + "th node from end: " + findNthFromEnd(head, n));
    }
}
