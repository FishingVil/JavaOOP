package hus.oop.integration;

import java.util.Random;

public class TestIntegrationCalculator {
    private MyPolynomial polynomial;

    public TestIntegrationCalculator(MyPolynomial polynomial) {
        this.polynomial = polynomial;
    }

    public static void main(String[] args) {
        /* TODO
         - Thực hiện các yêu cầu trong từng hàm test.
         - Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_Integration>.txt
           (ví dụ, NguyenVanA_123456_Integration.txt)
         - Nộp file kết quả chạy chương trình (file text trên) cùng với các file source code.
         */
        TestIntegrationCalculator test = new TestIntegrationCalculator(null);
        test.testArrayPolynomial();
        test.testListPolynomial();
    }

    public void testArrayPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyArrayPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 1.0 và 5.0.
         */
        System.out.println("===== Test ArrayPolynomial =====");

        Random rand = new Random();
        int size = rand.nextInt(5) + 3;
        double[] coefs = new double[size];
        for (int i = 0; i < size; i++) {
            coefs[i] = Math.round((rand.nextDouble() * 10 - 5) * 100.0) / 100.0;
        }

        MyArrayPolynomial poly = new MyArrayPolynomial();
        for (int i = 0; i < coefs.length; i++) {
            poly.append(coefs[i]);
        }

        System.out.println("Đa thức ban đầu: " + poly);

        poly.append(2.0);
        System.out.println("Sau append(2.0): " + poly);

        poly.set(-3.5, 1);
        System.out.println("Sau set(-3.5, 1): " + poly);

        MyArrayPolynomial other = new MyArrayPolynomial();
        other.append(1);
        other.append(1);
        other.append(1);

        System.out.println("Đa thức khác: " + other);

        System.out.println("poly + other = " + poly.plus(other));
        System.out.println("poly - other = " + poly.minus(other));
        System.out.println("poly * other = " + poly.multiply(other));
        System.out.println("poly(2.0) = " + poly.evaluate(2.0));

        IntegrationCalculator calc = new IntegrationCalculator(poly);

        calc.setIntegrator(new TrapezoidRule(1e-6, 20));
        System.out.println("Tích phân Trapezoid từ 1.0 đến 5.0 = " + calc.integrate(1.0, 5.0));

        calc.setIntegrator(new MidpointRule(1e-6, 20));
        System.out.println("Tích phân Midpoint từ 1.0 đến 5.0 = " + calc.integrate(1.0, 5.0));

        calc.setIntegrator(new SimpsonRule(1e-6, 20));
        System.out.println("Tích phân Simpson từ 1.0 đến 5.0 = " + calc.integrate(1.0, 5.0));
    }

    public void testListPolynomial() {
        /* TODO
         - Sinh ngẫu nhiên một số nguyên, lưu vào biến size. Sinh ngẫu nhiên size số thực. Tạo đa thức kiểu MyListPolynomial
           với các hệ số là các số thực vừa sinh ra, lưu vào biến polynomial.
         - Viết chương trình test các chức năng đa thức (thêm phần tử vào đa thức, xóa phần tử trong đa thức,
           sửa hệ số tại một phần tử, cộng 2 đa thức, trừ 2 đa thức, nhân 2 đa thức, tính giá trị của đa thức khi biết
           giá trị của x).
         - Tính tích phân xác định của đa thức được tạo ban đầu với các cận tích phân là 2.0 và 6.0.
         */
        System.out.println("===== Test ListPolynomial =====");

        Random rand = new Random();
        int size = rand.nextInt(5) + 3;
        double[] coefs = new double[size];
        for (int i = 0; i < size; i++) {
            coefs[i] = Math.round((rand.nextDouble() * 10 - 5) * 100.0) / 100.0;
        }

        MyListPolynomial poly = new MyListPolynomial();
        for (int i = 0; i < coefs.length; i++) {
            poly.append(coefs[i]);
        }

        System.out.println("Đa thức ban đầu: " + poly);

        poly.append(2.0);
        System.out.println("Sau append(2.0): " + poly);

        poly.set(-3.5, 1);
        System.out.println("Sau set(-3.5, 1): " + poly);

        MyListPolynomial other = new MyListPolynomial();
        other.append(1);
        other.append(1);
        other.append(1);

        System.out.println("Đa thức khác: " + other);

        System.out.println("poly + other = " + poly.plus(other));
        System.out.println("poly - other = " + poly.minus(other));
        System.out.println("poly * other = " + poly.multiply(other));
        System.out.println("poly(2.0) = " + poly.evaluate(2.0));

        IntegrationCalculator calc = new IntegrationCalculator(poly);

        calc.setIntegrator(new TrapezoidRule(1e-6, 20));
        System.out.println("Tích phân Trapezoid từ 2.0 đến 6.0 = " + calc.integrate(2.0, 6.0));

        calc.setIntegrator(new MidpointRule(1e-6, 20));
        System.out.println("Tích phân Midpoint từ 2.0 đến 6.0 = " + calc.integrate(2.0, 6.0));

        calc.setIntegrator(new SimpsonRule(1e-6, 20));
        System.out.println("Tích phân Simpson từ 2.0 đến 6.0 = " + calc.integrate(2.0, 6.0));
    }
}
