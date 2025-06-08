package hus.oop.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        double x = (lower + upper) / 2.0; // Khởi tạo điểm bắt đầu giữa khoảng
        for (int i = 0; i < maxIterations; i++) {
            double fx = function.evaluate(x);
            double dfx = function.derivative(x);
            if (Math.abs(dfx) < 1e-14) {  // Tránh chia cho 0 hoặc gần 0
                break;
            }
            double xNext = x - fx / dfx;
            if (Math.abs(xNext - x) < tolerance) {
                return xNext;
            }
            x = xNext;
        }
        return x;
    }
}
