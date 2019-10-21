package lesson17.classwork;

import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinkedList<T> {

    private Node<T> head;

    private int size = 0;

    public void add(T element) {
        if (isEmpty()) {
            head = new Node<>(element);
        } else {
            tail().link(new Node<>(element));
        }
        size++;
    }

    public void add(int index, T element) {
        Node<T> previous = navigate(index -1);
        Node<T> next = previous.next();
        Node<T> added = new Node<T>(element, next);
        previous.link(added);
        size++;
    }

    public void remove(int index) {
        Node<T> removed = navigate(index);
    }

    public T get(int index) {
        return navigate(index).getValue();
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

    private Node<T> navigate(int index) {
        Objects.checkIndex(index, size);
        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = head.next();
        }
        return n;
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
