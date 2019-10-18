package lesson17;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Capacity can't be: "+
                    initialCapacity);
        }
    }

    private T elementData(int index) {
        return (T) elementData[index];
    }

    public void add(T element) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size] = element;
        size++;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size);

        if (size == elementData.length) {
            elementData = grow();
        }

        System.arraycopy(elementData, index, elementData,
                index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    private Object[] grow() {
        return elementData = Arrays.copyOf(elementData, newCapacity(size + 1));
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + oldCapacity / 2;
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = MAX_ARRAY_SIZE;
        }
        if (newCapacity - minCapacity <= 0) {
            throw new OutOfMemoryError();
        }
        return newCapacity;
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T oldValue = elementData(index);
        final int newSize;
        if ((newSize = size - 1) > index) {
            System.arraycopy(elementData, index + 1, elementData,
                    index, newSize - index);
        }
        elementData[size = newSize] = null;
        return oldValue;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return elementData(index);
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++) {
            elementData[i] = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            try {
                int i = cursor;
                T next = get(i);
                cursor = ++i;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public String toString() {
        Iterator<T> it = iterator();
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        while (true) {
            T t = it.next();
            sb.append(t);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(", ");
        }
    }
}
