import java.util.Iterator;

public class BackwardLinkedListDemo {
    public static void main(String[] args) {
        BackwardLinkedList<String> strings = new BackwardLinkedList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");


        Iterator<String> itr = strings.iterator();
        int count = 0;
        String s = "";
        while (itr.hasNext()) {
            if (count == 1) {
                itr.remove();
            }
            s = itr.next();
            count++;
        }

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
