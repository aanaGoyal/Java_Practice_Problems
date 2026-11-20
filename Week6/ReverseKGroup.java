package Week6;

public class ReverseKGroup {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverseKGroup(Node head, int k) {
        Node node = head;
        int count = 0;

        // check if there are at least k nodes left
        while (node != null && count < k) {
            node = node.next;
            count++;
        }

        if (count < k) {
            return head; // less than k nodes remain, leave as is
        }

        Node prev = reverseKGroup(node, k); // recursively reverse the rest
        Node curr = head;

        for (int i = 0; i < k; i++) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseKGroup(head, 2);
        print(head);
    }
}
