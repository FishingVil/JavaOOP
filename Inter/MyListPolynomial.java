package hus.oop.integration;

import java.util.ArrayList;
import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        coefficients = new ArrayList<>();
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= coefficients.size()) {
            return 0;
        }
        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        double[] arr = new double[coefficients.size()];
        for (int i = 0; i < coefficients.size(); i++) {
            arr[i] = coefficients.get(i);
        }
        return arr;
    }

    @Override
    public MyListPolynomial append(double coefficient) {
        coefficients.add(coefficient);
        return this;
    }

    @Override
    public MyListPolynomial add(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index không được âm");
        }
        while (index >= coefficients.size()) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficients.get(index) + coefficient);
        return this;
    }

    @Override
    public MyListPolynomial set(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index không được âm");
        }
        while (index >= coefficients.size()) {
            coefficients.add(0.0);
        }
        coefficients.set(index, coefficient);
        return this;
    }

    @Override
    public int degree() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        int deg = degree();
        for (int i = deg; i >= 0; i--) {
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        int deg = degree();
        MyListPolynomial deriv = new MyListPolynomial();
        if (deg == 0) {
            deriv.append(0);
            return deriv;
        }
        for (int i = 1; i <= deg; i++) {
            deriv.append(i * coefficients.get(i));
        }
        return deriv;
    }

    @Override
    public MyListPolynomial plus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double sum = this.coefficient(i) + right.coefficient(i);
            result.append(sum);
        }
        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double diff = this.coefficient(i) - right.coefficient(i);
            result.append(diff);
        }
        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial right) {
        int degLeft = this.degree();
        int degRight = right.degree();
        MyListPolynomial result = new MyListPolynomial();
        for (int i = 0; i <= degLeft + degRight; i++) {
            result.append(0);
        }
        for (int i = 0; i <= degLeft; i++) {
            for (int j = 0; j <= degRight; j++) {
                double oldVal = result.coefficient(i + j);
                result.set(oldVal + this.coefficient(i) * right.coefficient(j), i + j);
            }
        }
        return result;
    }
}
