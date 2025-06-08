package hus.oop.rootsolver;

public class MyMath {
    public static double sin(double x) {
        x = x % (2 * Math.PI);
        double term = x;  // T0
        double sum = term;
        for (int n = 1; n < 10; n++) {
            term = -term * x * x / (2 * n * (2 * n + 1));
            sum += term;
        }
        return sum;
    }

    public static double cos(double x) {
        x = x % (2 * Math.PI);
        double term = 1.0;  // T0
        double sum = term;
        for (int n = 1; n < 10; n++) {
            term = -term * x * x / ((2 * n - 1) * (2 * n));
            sum += term;
        }
        return sum;
    }

    public double exp(double x) {
        double term = 1.0; // T0
        double sum = term;
        for (int n = 1; n < 20; n++) {
            term = term * x / n;
            sum += term;
        }
        return sum;
    }

    // ln(1 + x), với |x| < 1
    public double ln(double x) {
        if (x <= -1) throw new IllegalArgumentException("ln(1+x) chỉ định nghĩa với x > -1");
        if (x == 0) return 0;

        if (Math.abs(x) >= 1) {
            throw new IllegalArgumentException("x phải thỏa mãn |x| < 1 để khai triển Taylor");
        }

        double term = x;  // T1
        double sum = term;
        for (int n = 2; n <= 20; n++) {
            term = -term * x * (n - 1) / n;  // công thức quy nạp
            sum += term;
        }
        return sum;
    }
}
