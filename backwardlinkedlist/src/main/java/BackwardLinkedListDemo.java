import java.util.Iterator;

public class BackwardLinkedListDemo {
    public static void main(String[] args) {
        BackwardLinkedList<String> strings = new BackwardLinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        System.out.println(strings);

        Iterator<String> itr = strings.iterator();
        while (itr.hasNext()) {
           itr.next();
        }
        System.out.println("Removing last element");
        itr.remove();

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
