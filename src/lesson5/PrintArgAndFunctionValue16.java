package lesson5;

public class PrintArgAndFunctionValue16 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 3, 9, 4, 16};
        for (int i = 0; i < arr.length - 1; i += 2) {
            System.out.println(arr[i] + " " + arr[i+1]);
        }
    }
}
