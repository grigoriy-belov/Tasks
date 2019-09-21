package lesson5;

public class ArrayTask21 {
    public static void main(String[] args) {
        //Дана последовательность действительных чисел a1, a2, ..., аn. Указать те ее элементы, которые
        //принадлежат отрезку [с, d].
        double[] arr = {2.4, 1.3, 0.3, 5.7, 9.0, 3.7};
        double c = 2.0;
        double d = 6.0;

        for (double i : arr) {
            if (i >= c && i <= d)
                System.out.println(i);
        }
    }
}
