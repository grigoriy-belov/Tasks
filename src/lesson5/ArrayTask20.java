package lesson5;

public class ArrayTask20 {
    //Дан одномерный массив A[N]. Найти: mаx(а2, а4, ..., a2k) + min(а1, а3, ..., a2k-1).
    public static void main(String[] args) {
        int[] arr = {55, 6, 4, 3, 8, 9, 1};

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i] > max) {
                max = arr[i];
            } else if (i != arr.length-1 && arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(max + min);
    }
}
