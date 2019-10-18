package lesson17;

import java.util.*;

public class MyArrayListDemo {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(arr);
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("After adding 5 elements in list: " + list);

        System.out.println("Getting element by index 3: " + list.get(3));

        list.add(3, 0);
        System.out.println("After inserting '0' on position of index 3: " + list);

        list.remove(2);
        System.out.println("After removing element on the index 2: " + list);

        list.clear();
        System.out.println("After clearing the list: " + list);
    }
}
