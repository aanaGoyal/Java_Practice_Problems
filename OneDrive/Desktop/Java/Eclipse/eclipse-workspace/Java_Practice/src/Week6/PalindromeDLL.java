package Week6;

public class PalindromeDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static boolean isPalindrome(Node head) {
        Node front = head;
        Node rear = head;

        while (rear.next != null) {
            rear = rear.next; // move rear to the last node
        }

        while (front != rear && rear.next != front) {
            if (front.data != rear.data) {
                return false;
            }
            front = front.next;
            rear = rear.prev;
        }

        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
