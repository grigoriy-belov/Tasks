package lesson17;

public class BackwardLinkedListDemo {
    public static void main(String[] args) {
        BackwardLinkedList<String> strings = new BackwardLinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

        for (String string : strings) {
            System.out.println(string);
        }

    }
}
