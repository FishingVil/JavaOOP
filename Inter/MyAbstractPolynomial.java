package hus.oop.integration;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     *
     * @return String mô tả về đa thức.
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int deg = degree();
        for (int i = 0; i <= deg; i++) {
            double coeff = coefficient(i);
            if (i > 0 && coeff >= 0) {
                sb.append(" + ");
            } else if (coeff < 0) {
                sb.append(" - ");
                coeff = -coeff;
            }
            if (i == 0 || coeff != 1) {
                sb.append(coeff);
            }
            if (i >= 1) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Lấy đạo hàm đa thức.
     *
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        int deg = degree();
        if (deg == 0) {
            return new double[]{0};
        }
        double[] derivCoeffs = new double[deg];
        for (int i = 1; i <= deg; i++) {
            derivCoeffs[i - 1] = i * coefficient(i);
        }
        return derivCoeffs;
    }
}
