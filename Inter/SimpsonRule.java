package hus.oop.integration;

public class SimpsonRule implements MyIntegrator {
    private double precision;
    private int maxIterations;

    public SimpsonRule(double precision, int maxIterations) {
        /* TODO */
        this.precision = precision;
        this.maxIterations = maxIterations;
    }

    /**
     * Tính xấp xỉ giá trị tích phân. Giá trị xấp xỉ được chấp nhận nếu phép tính đạt độ chính xác đã cho,
     * hoặc có số vòng vượt quá ngưỡng quy định.
     * Độ chính xác được xác định như sau, chọn n0 tùy ý, sau đó tính I_n với n = n0, 2n0, 4n0, ...
     * Việc tính toán dừng lại khi |I_2n - In|/3 < eps (precision), hoặc số lần chia đôi vượt quá ngưỡng quy định (maxIterations).
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @return
     */
    @Override
    public double integrate(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */
        int n = 4;
        if (n % 2 != 0) n++; // đảm bảo n chẵn
        double I_n = integrate(polynomial, lower, upper, n);
        double I_2n;
        int iterations = 0;

        while (true) {
            n *= 2;
            if (n % 2 != 0) n++;
            I_2n = integrate(polynomial, lower, upper, n);
            if (Math.abs(I_2n - I_n) / 3.0 < precision || iterations >= maxIterations) {
                return I_2n;
            }
            I_n = I_2n;
            iterations++;
        }
    }

    /**
     * Tính xấp xỉ giá trị tích phân với numOfSubIntervals (số chẵn) khoảng phân hoạch đều.
     *
     * @param polynomial
     * @param lower
     * @param upper
     * @param numOfSubIntervals
     * @return giá trị xấp xỉ giá trị tích phân.
     */
    private double integrate(MyPolynomial polynomial, double lower, double upper, int numOfSubIntervals) {
        /* TODO */
        if (numOfSubIntervals % 2 != 0) {
            throw new IllegalArgumentException("Số khoảng phân hoạch phải là số chẵn trong quy tắc Simpson.");
        }

        double h = (upper - lower) / numOfSubIntervals;
        double sum = polynomial.evaluate(lower) + polynomial.evaluate(upper);

        for (int i = 1; i < numOfSubIntervals; i++) {
            double x = lower + i * h;
            if (i % 2 == 0) {
                sum += 2 * polynomial.evaluate(x);
            } else {
                sum += 4 * polynomial.evaluate(x);
            }
        }

        return (h / 3.0) * sum;
    }
}
