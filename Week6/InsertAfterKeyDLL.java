package Week6;

public class InsertAfterKeyDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insertAfter(Node head, int key, int value) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            return head; // key not found
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;

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
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;

        head = insertAfter(head, 20, 25);
        print(head);
    }
}
