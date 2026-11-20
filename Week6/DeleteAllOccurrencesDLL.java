package Week6;

public class DeleteAllOccurrencesDLL {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node deleteAllOccurrences(Node head, int value) {
        Node temp = head;

        while (temp != null) {
            Node nextNode = temp.next;

            if (temp.data == value) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // deleting head node
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
            }

            temp = nextNode;
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
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(3);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.prev = head.next.next.next;

        head = deleteAllOccurrences(head, 3);
        print(head);
    }
}
