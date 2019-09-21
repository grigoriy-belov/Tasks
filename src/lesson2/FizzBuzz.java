package lesson2;

public class FizzBuzz {
    public static void main(String[] args) {
        int number = 347_693_485;

        System.out.println(number%10);
        while (number/10 > 0) {
            int n = number % 10;

            if (number % 2 == 0 && number % 3 == 0){
                System.out.println("fizzbuzz");
            } else if (number % 2 == 0){
                System.out.println("fizz");
            } else {
                System.out.println("buzz");
            }

        }
    }
}
