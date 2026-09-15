package Week7;

public class CircularLinkedListOperations {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node last; // points to the last node, last.next is always head

    static void insert(int data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            last.next = last;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
    }

    static void printForward() {
        if (last == null) {
            return;
        }
        Node head = last.next;
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    // Recursion used to print the circular list in reverse order
    static void printReverse(Node curr, Node head) {
        if (curr.next != head) {
            printReverse(curr.next, head);
        }
        System.out.print(curr.data + " -> ");
    }

    static int findMiddle() {
        if (last == null) {
            return -1;
        }
        Node head = last.next;
        Node slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        for (int val : new int[]{10, 20, 30, 40, 50}) {
            insert(val);
        }

        System.out.print("Forward: ");
        printForward();

        System.out.print("Reverse: ");
        printReverse(last.next, last.next);
        System.out.println();

        System.out.println("Middle element: " + findMiddle());
    }
}
