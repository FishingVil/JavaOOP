package hus.oop.rootsolver;

public class RootFindingTestDrive {
    public static void main(String[] args) {
        /*
        TODO

        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootFinding>.txt
        (ví dụ, NguyenVanA_123456_RootFinding.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootFinding>.zip (ví dụ, NguyenVanA_123456_RootFinding.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();

    }

    public static void testRootSolver() {
        /*
         TODO

         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm của thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm của hàm tìm được.
         */
        AbstractFunction function = new UnivariateRealFunction();

        double lower = 1.0;   // Khoảng tìm nghiệm (bạn điều chỉnh tùy hàm)
        double upper = 3.0;

        RootSolver bisectionSolver = new BisectionSolver(1e-7, 1000);
        RootSolver newtonSolver = new NewtonRaphsonSolver(1e-7, 1000);
        RootSolver secantSolver = new SecantSolver(1e-7, 1000);

        // Tạo đối tượng tìm nghiệm cho từng phương pháp
        UnivariateRealRootFinding bisectionFinding = new UnivariateRealRootFinding(function, bisectionSolver);
        UnivariateRealRootFinding newtonFinding = new UnivariateRealRootFinding(function, newtonSolver);
        UnivariateRealRootFinding secantFinding = new UnivariateRealRootFinding(function, secantSolver);

        System.out.println("Tìm nghiệm hàm f(x) = x * sin(x) - 3");

        System.out.println("\nPhương pháp Bisection:");
        try {
            double rootBisection = bisectionFinding.solve(lower, upper);
            System.out.println("Nghiệm tìm được: " + rootBisection);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("\nPhương pháp Newton-Raphson:");
        try {
            double rootNewton = newtonFinding.solve(lower, upper);
            System.out.println("Nghiệm tìm được: " + rootNewton);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("\nPhương pháp Secant:");
        try {
            double rootSecant = secantFinding.solve(lower, upper);
            System.out.println("Nghiệm tìm được: " + rootSecant);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
