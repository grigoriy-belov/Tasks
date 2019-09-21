package lesson5;

public class ArrayTask69 {
//    69. В одномерном массиве с четным количеством элементов (2N) находятся координаты N точек
//    плоскости. Они располагаются в следующем порядке: x1, y1, х2, y2, x3, y3, и т.д. Найти номера самых
//    удаленных друг от друга точек и наименее удаленных друг от друга точек.

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 6, 6, 15, 10, 9, 9};

        double maxDistance = 0;
        double minDistance = Double.MAX_VALUE;
        int maxDistanceX1 = 0;
        int maxDistanceX2 = 0;
        int maxDistanceY1 = 0;
        int maxDistanceY2 = 0;
        int minDistanceX1 = 0;
        int minDistanceX2 = 0;
        int minDistanceY1 = 0;
        int minDistanceY2 = 0;

        for (int i = 0; i < arr.length - 1 ; i += 2) {
            int x1 = arr[i];
            int y1 = arr[i+1];
            for (int j = i + 2; j < arr.length - 1; j += 2) {
                int x2 = arr[j];
                int y2 = arr[j+1];
                double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
                if (distance > maxDistance) {
                    maxDistance = distance;
                    maxDistanceX1 = i;
                    maxDistanceY1 = i + 1;
                    maxDistanceX2 = j;
                    maxDistanceY2 = j + 1;
                }
                if (distance < minDistance) {
                    minDistance = distance;
                    minDistanceX1 = i;
                    minDistanceY1 = i + 1;
                    minDistanceX2 = j;
                    minDistanceY2 = j + 1;
                }
            }
        }
        System.out.println("The smallest distance is between dots: " + minDistanceX1 + "" + minDistanceY1 + " " + minDistanceX2 + "" + minDistanceY2);
        System.out.println("The largest distance is between dots: " + maxDistanceX1 + "" + maxDistanceY1 + " " + maxDistanceX2 + "" + maxDistanceY2);
    }
}
