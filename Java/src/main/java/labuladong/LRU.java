package labuladong;

public class LRU {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // System.out.println(new LRU().hash(i));
        }
    }

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleList {
        Node head;
        Node tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
        }

        public void addLast(int k, int v) {
            Node node = new Node(k, v);
            node.prev = tail.prev;
            node.next = tail;

            node.prev.next = node;
            tail.prev = node;
        }

        public void remove() {

        }

    }
}
