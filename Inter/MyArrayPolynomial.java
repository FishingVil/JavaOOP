package hus.oop.integration;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        coefficents = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public double coefficient(int index) {
        if (index < 0 || index >= size) {
            return 0;
        }
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        double[] result = new double[size];
        System.arraycopy(coefficents, 0, result, 0, size);
        return result;
    }

    @Override
    public MyArrayPolynomial append(double coefficient) {
        if (size == coefficents.length) {
            allocateMore();
        }
        coefficents[size] = coefficient;
        size++;
        return this;
    }

    @Override
    public MyArrayPolynomial add(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index không được âm");
        }
        while (index >= size) {
            append(0);
        }
        coefficents[index] += coefficient;
        return this;
    }

    @Override
    public MyArrayPolynomial set(double coefficient, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index không được âm");
        }
        while (index >= size) {
            append(0);
        }
        coefficents[index] = coefficient;
        return this;
    }

    @Override
    public int degree() {
        for (int i = size - 1; i >= 0; i--) {
            if (coefficents[i] != 0) {
                return i;
            }
        }
        return 0; // đa thức 0 có bậc 0
    }

    @Override
    public double evaluate(double x) {
        double result = 0;
        for (int i = degree(); i >= 0; i--) {
            result = result * x + coefficents[i];
        }
        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        int deg = degree();
        if (deg == 0) {
            MyArrayPolynomial deriv = new MyArrayPolynomial();
            deriv.append(0);
            return deriv;
        }
        MyArrayPolynomial deriv = new MyArrayPolynomial();
        for (int i = 1; i <= deg; i++) {
            deriv.append(i * coefficents[i]);
        }
        return deriv;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double sum = this.coefficient(i) + right.coefficient(i);
            result.append(sum);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial right) {
        int maxDegree = Math.max(this.degree(), right.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();
        for (int i = 0; i <= maxDegree; i++) {
            double diff = this.coefficient(i) - right.coefficient(i);
            result.append(diff);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial multiply(MyPolynomial right) {
        int degLeft = this.degree();
        int degRight = right.degree();
        MyArrayPolynomial result = new MyArrayPolynomial();
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

    /**
     * Tăng kích thước mảng lên gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        double[] newCoeffs = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoeffs, 0, coefficents.length);
        coefficents = newCoeffs;
    }
}
