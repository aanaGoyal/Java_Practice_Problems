package Week6;

public class DesignLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    static class MyLinkedList {
        Node head;
        int size;

        MyLinkedList() {
            head = null;
            size = 0;
        }

        int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        void addAtTail(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            }
            size++;
        }

        void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
                return;
            }
            Node newNode = new Node(val);
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }

        void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
            } else {
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }
                prev.next = prev.next.next;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2); // list becomes 1 -> 2 -> 3
        System.out.println("Get index 1: " + list.get(1)); // expect 2

        list.deleteAtIndex(1); // list becomes 1 -> 3
        System.out.println("Get index 1 after delete: " + list.get(1)); // expect 3
    }
}
