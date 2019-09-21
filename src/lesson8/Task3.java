package lesson8;

public class Task3 {
    public static void main(String[] args) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 4;
        int x3 = -1;
        int y3 = -3;

        double a = getDistance(x1, x2, y1, y2);
        double b = getDistance(x3, x2, y3, y2);
        double c = getDistance(x1, x3, y1, y3);

        if (!checkTriangle(a, b, c)) {
            System.out.println("Points don't compose a triangle");
            return;
        }
        System.out.println("Square of the triangle is: " + getSquareOfTriangle(x1, y1, x2, y2, x3, y3));
    }

    public static double getSquareOfTriangle(double x1, double y1, double x2, double y2,
                                             double x3, double y3) {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    public static boolean checkTriangle(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) return false;
        else return true;
    }

    public static double getDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.abs(x1-x2)) + Math.sqrt(Math.abs(y1-y2));
    }
}
