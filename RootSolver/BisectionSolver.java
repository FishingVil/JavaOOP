package hus.oop.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection)
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double a = lower;
        double b = upper;
        double fa = function.evaluate(a);
        double fb = function.evaluate(b);

        if (fa * fb > 0) {
            throw new IllegalArgumentException("Hàm không đổi dấu trên khoảng [" + a + ", " + b + "]");
        }

        double c = a;
        for (int i = 0; i < maxIterations; i++) {
            c = (a + b) / 2.0;
            double fc = function.evaluate(c);

            if (Math.abs(fc) < tolerance || (b - a) / 2 < tolerance) {
                return c;
            }

            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }
        return c;
    }
}
