package Week6;

public class DoublyLinkedListOperations {

    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    static class DoublyLinkedList {
        Node head;

        void insertAtEnd(int data) {
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
            newNode.prev = temp;
        }

        void deleteNode(int key) {
            Node temp = head;
            while (temp != null && temp.data != key) {
                temp = temp.next;
            }
            if (temp == null) {
                return; // not found
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next; // deleting head
            }
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
        }

        void printForward() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        for (int val : new int[]{10, 20, 30, 40}) {
            dll.insertAtEnd(val);
        }

        dll.printForward();
        dll.deleteNode(20);
        System.out.print("After deleting 20: ");
        dll.printForward();
    }
}
