package lesson5;

public class ArrayTask105 {
//    105. Вычислить сумму и число положительных элементов матрицы A[N, N], находящихся над главной
//    диагональю.

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {15, 16, 17, 18, 19}
        };

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length ; j++) {
                if (matrix[i][j] > 0)
                    sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}
