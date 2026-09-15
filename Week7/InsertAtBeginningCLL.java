package Week7;

public class InsertAtBeginningCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insertAtBeginning(Node head, int data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node temp = head;
        while (temp.next != head) {
            temp = temp.next; // find the last node
        }

        newNode.next = head;
        temp.next = newNode;

        return newNode; // new node becomes the head
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
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = head; // make circular

        head = insertAtBeginning(head, 10);
        print(head);
    }
}
