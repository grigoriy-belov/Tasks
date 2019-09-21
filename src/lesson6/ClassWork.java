package lesson6;

public class ClassWork {
    public static void main(String[] args) {
        System.out.println(triangleSquare(-1, -3, 3, 4, 5, -5));
        System.out.println(getGCD(30, 18));
        System.out.println(getLCM(30, 18));
        System.out.println(getFourNumbersGCD(30, 18, 16, 32));
        System.out.println(sumOfGreaterAndLower(5,6,7));
        System.out.println(getSumOfNumbers(123));
        System.out.println(getCountOfNumbers(1234));
        System.out.println(isSymmetrical("asasa", 0,4));
    }

    public static int triangleSquare(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x2-x1) * (y3-y1) - (x3-x1) * (y2-y1))/2;
    }

    public static int getGCD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        return a + b;
    }

    public static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    public static int getFourNumbersGCD(int a, int b, int c, int d) {
        return getGCD(getGCD(a, b), getGCD(c, d));
    }

    public static int sumOfGreaterAndLower(int a, int b, int c) {
        int max = Math.max(a, b);
        max = Math.max(max, c);

        int min = Math.min(a, b);
        min = Math.min(min, c);

        return max + min;
    }

    public static int getSumOfNumbers(int a) {
        if (a == 0) {
            return 0;
        } else {
            return a % 10 + getSumOfNumbers(a/10);
        }
    }

    public static int getCountOfNumbers(int a) {
        if (a == 0) {
            return 0;
        } else {
            return 1 + getCountOfNumbers(a/10);
        }
    }

    public static boolean isSymmetrical(String s, int i, int j) {
        if (i == j) {
            return true;
        } else {
            char[] chars = s.toCharArray();
            return chars[i] == chars[j] && isSymmetrical(s,i + 1, j - 1);
        }
    }
}
