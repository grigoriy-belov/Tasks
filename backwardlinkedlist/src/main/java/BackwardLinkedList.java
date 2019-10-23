import java.util.*;

public class BackwardLinkedList<T> implements Iterable<T>  {
    private Node<T> tail;

    private int size = 0;

    public void add(T element) {
        if (isEmpty()) {
            tail = new Node<>(element);
        } else {
            tail = new Node<>(element, tail);
        }
        size++;
    }

    public void add(int index, T element) {
        Node<T> added;
        if (index == 0) {
            head().link(new Node<>(element));
        } else if (index == size){
            tail = new Node<>(element, tail);
        } else {
            Node<T> previous = navigate(index - 1);
            Node<T> next = navigate(index);
            added = new Node<T>(element, previous);
            next.link(added);
        }
        size++;
    }

    public T remove(int index) {
        if (index == size) {
            throw new IndexOutOfBoundsException("Can't remove element, index is equal to size (" + size + ")");
        }
        Node<T> removed;
        if (index == 0) {
            removed = head();
            if (size == 1) {
                tail = null;
            } else {
                navigate(1).unlink();
            }
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.previous;
        } else {
            Node<T> previous = navigate(index - 1);
            Node<T> next = navigate(index + 1);
            removed = next.previous();
            next.link(previous);
        }
        size--;
        return removed.getValue();
    }

    public boolean contains(T element) {
        if (isEmpty()) return false;

        Node<T> n = tail;

        do {
            if (Objects.equals(element, n.getValue()))
                return true;
            n = n.previous();
        } while (n != null);

        return false;
    }

    public T get(int index) {
        return navigate(index).getValue();
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void clear() {
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    private Node<T> navigate(int index) {
        Objects.checkIndex(index, size);
        Node<T> n = tail;
        for (int i = size - 1; i > index; i--) {
            n = n.previous();
        }
        return n;
    }

    private Node<T> head() {
        Node<T> n = tail;
        while (n.hasPrevious()) {
            n = n.previous();
        }
        return n;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackwardLinkedList<?> that = (BackwardLinkedList<?>) o;
        return size == that.size && Objects.equals(that.tail, tail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tail);
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("]");
        sb.insert(0, tail.getValue());

        Node<T> n = tail;
//
//        for (T element : this) {
//            sb.append(", ").append(element);
//        }
        while (n.hasPrevious()) {
            n = n.previous();
            sb.insert(0, ", ").insert(0, n.getValue());
        }
        return sb.insert(0, "[").toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr<>(this);
    }

    private static final class Itr<E> implements Iterator<E> {

        private Node<E> previous;
        private Node<E> current;
        private Node<E> next;
        private Node<E> tail;
        BackwardLinkedList<E> list;

        Itr(BackwardLinkedList<E> list) {
            this.current = new Node<>(null, null);
            this.next = new Node<>(null, null);
            this.previous = new Node<>(null, list.head().previous());
            this.tail = list.tail;
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            Node<E> n = tail;
            next = null;
            while (!Objects.equals(n, current) && n != null) {
                next = n;
                n = n.previous();
            }
            return next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = current;
            current = next;
            return next.getValue();
        }

        @Override
        public void remove() {
            if (next == null) {
                list.tail = previous;
            } else {
                next.link(previous);
            }
        }
    }

    private static final class Node<E> {
        private E value;
        private Node<E> previous;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> previous) {
            this.value = value;
            this.previous = previous;
        }

        public void link(Node<E> previous) {
            this.previous = previous;
        }

        public void unlink() {
            this.previous = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> previous() {
            return previous;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(previous, node.previous);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, previous);
        }
    }
}
