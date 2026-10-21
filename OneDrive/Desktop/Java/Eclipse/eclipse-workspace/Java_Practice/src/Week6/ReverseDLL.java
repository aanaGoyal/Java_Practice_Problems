package Week6;

public class ReverseDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverse(Node head) {
        Node curr = head, temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev; // move to next node (which is old prev)
        }

        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " <-> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head = reverse(head);
        print(head);
    }
}
