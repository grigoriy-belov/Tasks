package lesson5;

public class NegativeOrPositive3 {
    public static void main(String[] args) {
        int[] arr = {-1, 3, -1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                System.out.println("Positive number first");
                break;
            } else if (arr[i] < 0) {
                System.out.println("Negative number first");
                break;
            }
        }
    }
}
