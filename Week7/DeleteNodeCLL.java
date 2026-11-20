package Week7;

public class DeleteNodeCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node deleteNode(Node head, int key) {
        if (head == null) {
            return null;
        }

        Node curr = head, prev = null;

        // find the node to delete
        while (curr.data != key) {
            prev = curr;
            curr = curr.next;
            if (curr == head) {
                return head; // key not found
            }
        }

        if (curr == head && curr.next == head) {
            return null; // only one node in the list
        }

        if (curr == head) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
        } else {
            prev.next = curr.next;
        }

        return head;
    }

    static void print(Node head) {
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head; // make circular

        head = deleteNode(head, 20);
        print(head);
    }
}
