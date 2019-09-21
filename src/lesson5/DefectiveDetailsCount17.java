package lesson5;

public class DefectiveDetailsCount17 {
    public static void main(String[] args) {
        double a = 5;
        double d = 0.1;
        double[] detailSizes = {5.1, 5.033, 5.5, 4.5, 5.5, 5.05};
        int count = 0;
        for (int i = 0; i < detailSizes.length; i++) {
            if (Math.abs(detailSizes[i] - a) > d) {
                System.out.println(detailSizes[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No defective details found");
        } else {
            System.out.println(count + " defective details found");
        }
    }
}
