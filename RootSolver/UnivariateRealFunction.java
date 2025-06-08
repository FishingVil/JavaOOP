package hus.oop.rootsolver;

public class UnivariateRealFunction implements AbstractFunction {
    /**
     * Hàm số f(x) = x * sin(x) - 3 sử dụng MyMath.sin
     */
    @Override
    public double evaluate(double x) {
        return x * MyMath.sin(x) - 3;
    }

    /**
     * Đạo hàm f'(x) = sin(x) + x * cos(x) sử dụng MyMath
     */
    @Override
    public double derivative(double x) {
        return MyMath.sin(x) + x * MyMath.cos(x);
    }
}
