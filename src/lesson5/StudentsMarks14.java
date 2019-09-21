package lesson5;

public class StudentsMarks14 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 2, 2, 3, 5, 5, 2};

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
