package lesson5;

public class CountPositiveNegative9 {
    public static void main(String[] args) {
        double[] arr = {1, 2, -1, -3, 3, -6, 0, 0};

        int countNegative = 0;
        int countPositive = 0;
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                countPositive++;
            } else if (arr[i] < 0) {
                countNegative++;
            } else {
                countZero++;
            }
        }

        System.out.println(countPositive + " positive numbers");
        System.out.println(countNegative + " negative numbers");
        System.out.println(countZero + " zeros");
    }

}
