package Week7;

public class JosephusProblem {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static int josephus(int n, int k) {
        // build circular linked list with people numbered 1..n
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head; // make it circular

        Node curr = head;
        // prev already points to the last node (the one before head)

        while (curr.next != curr) {
            for (int i = 1; i < k; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next; // remove curr from the circle
            curr = curr.next;
        }

        return curr.data;
    }

    public static void main(String[] args) {
        int n = 7, k = 3;
        System.out.println("Winner position: " + josephus(n, k));
    }
}
