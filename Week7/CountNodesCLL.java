package Week7;

public class CountNodesCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static int countNodes(Node head) {
        if (head == null) {
            return 0;
        }
        int count = 1;
        Node temp = head.next;
        while (temp != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // make circular

        System.out.println("Total nodes: " + countNodes(head));
    }
}
