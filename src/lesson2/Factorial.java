package lesson2;

public class Factorial {
    public static void main(String[] args) {
        int first = 1;
        int second = 3;
        int third = 2;

        int max = 0;

        max = first > second ? first : second;
        max = max > third ? max : third;

        System.out.println(max);
    }
}
