package lesson17.classwork;

public class ForwardLinkedList<T> {

    private Node<T> head;

    private int size = 0;

    public void add(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
        } else {
            tail().link(new Node<>(element));
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node<T> tail() {
        Node<T> n = head;
        while (!n.isLast()) {
            n = n.next();
        }
        return n;
    }

    private final class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        public void link(Node<E> next) {
            this.next = next;
        }

        public void unlink() {
            this.next = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> next() {
            return next;
        }

        public boolean isLast() {
            return next == null;
        }
    }
}
