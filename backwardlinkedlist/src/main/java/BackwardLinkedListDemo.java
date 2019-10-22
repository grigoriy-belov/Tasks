public class BackwardLinkedListDemo {
    public static void main(String[] args) {
        BackwardLinkedList<String> strings = new BackwardLinkedList<>();
        strings.add("one");
        strings.add("two");
        System.out.println(strings.size());

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }

    }
}
