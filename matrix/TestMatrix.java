package hus.oop.matrix;

public class TestMatrix {
    public static void main(String[] args) {
        /* TODO
        Tạo ra 2 ma trận có cùng kích thước là một số ngẫu nhiên nằm trong đoạn [5, 10].
        Viết code thực hiện test các chức năng sau của các ma trận:
          - In ra 2 ma trận và 2 ma trận chuyển vị tương ứng.
          - In ra các đường chéo chính và đường chéo phụ của 2 ma trận.
          - In ra ma trận là ma trận tổng của 2 ma trận.
          - In ra ma trận là ma trận là hiệu của ma trận thứ nhất cho ma trận thứ 2.
          - In ra ma trận là ma trận tích của 2 ma trận.
          - In ra các số nguyên tố có trong 2 ma trận.

         Lưu kết quả chạy chương trình trên terminal vào file text và nộp cùng source code chương trình.
         File text kết quả được đặt tên như sau: <TenSinhVien_MaSinhVien_Matrix.txt> (Ví dụ, NguyenVanA_123456_Matrix.txt).
         */

        int size = 5 + (int) (Math.random() * 6); // random từ 5 đến 10
        MySquareMatrix m1 = new MySquareMatrix(size);
        MySquareMatrix m2 = new MySquareMatrix(size);

        System.out.println("Ma trận 1:");
        System.out.println(m1);
        System.out.println("\nMa trận 1 chuyển vị:");
        System.out.println(m1.transpose());

        System.out.println("\nMa trận 2:");
        System.out.println(m2);
        System.out.println("\nMa trận 2 chuyển vị:");
        System.out.println(m2.transpose());

        // Đường chéo chính và phụ
        System.out.print("\nĐường chéo chính của ma trận 1: ");
        printArray(m1.principalDiagonal());

        System.out.print("Đường chéo phụ của ma trận 1: ");
        printArray(m1.secondaryDiagonal());

        System.out.print("\nĐường chéo chính của ma trận 2: ");
        printArray(m2.principalDiagonal());

        System.out.print("Đường chéo phụ của ma trận 2: ");
        printArray(m2.secondaryDiagonal());

        // Tổng 2 ma trận
        System.out.println("\nMa trận tổng (m1 + m2):");
        System.out.println(m1.add(m2));

        // Hiệu (m1 - m2)
        System.out.println("\nMa trận hiệu (m1 - m2):");
        System.out.println(m1.minus(m2));

        // Tích (m1 * m2)
        System.out.println("\nMa trận tích (m1 * m2):");
        System.out.println(m1.multiply(m2));

        // Số nguyên tố trong ma trận
        System.out.print("\nCác số nguyên tố trong ma trận 1: ");
        printArray(m1.primes());

        System.out.print("Các số nguyên tố trong ma trận 2: ");
        printArray(m2.primes());
    }

    private static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Không có");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
