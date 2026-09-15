package Week7;

public class SearchCLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean search(Node head, int key) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        do {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head; // make circular

        System.out.println("Search 20: " + search(head, 20));
        System.out.println("Search 99: " + search(head, 99));
    }
}
