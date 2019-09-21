package lesson5;

public class ArrayTask29 {
    //        29. Даны целые положительные числа а1
    //, а2
    //, ..., an
    //. Найти среди них те, которые являются квадратами
    //
    //некоторого числа m.
    public static void main(String[] args) {

        int[] arr = {3, 9, 16, 128, 81, 99, 32, 44, 25, 125, 36, 64};
        int m = 4;
        for (int i = 0; i < arr.length; i++) {
            double j = arr[i];
            while (j > m) {
                j /= m;
            }
            if (j % m == 0) System.out.println(arr[i]);
        }
    }
}
