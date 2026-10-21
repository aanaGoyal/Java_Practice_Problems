package Week6;

public class SinglyLinkedListOperations {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedList {
        Node head;

        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        int countNodes() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        boolean linearSearch(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == key) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        // Fast and slow pointer approach
        int findMiddle() {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        void reverseIterative() {
            Node prev = null, curr = head;
            while (curr != null) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            head = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int val : new int[]{10, 20, 30, 40, 50}) {
            list.insert(val);
        }

        list.print();
        System.out.println("Node count: " + list.countNodes());
        System.out.println("Search 30: " + list.linearSearch(30));
        System.out.println("Middle element: " + list.findMiddle());

        list.reverseIterative();
        System.out.print("Reversed list: ");
        list.print();
    }
}
