package Week6;

public class SecondLargestDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static int findSecondLargest(Node head) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        Node temp = head;

        while (temp != null) {
            if (temp.data > largest) {
                secondLargest = largest;
                largest = temp.data;
            } else if (temp.data > secondLargest && temp.data != largest) {
                secondLargest = temp.data;
            }
            temp = temp.next;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(50);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;

        System.out.println("Second largest element: " + findSecondLargest(head));
    }
}
