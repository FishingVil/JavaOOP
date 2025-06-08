package hus.oop.statistics;
import java.util.Random;
public class TestStatistics {
    private Statistics statistics;

    public TestStatistics(Statistics statistics) {
        /* TODO */
    }

    public static void main(String[] args) {
        /* TODO
           - Thực hiện từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
             là <TenSinhVien_MaSinhVien_Statistics>.txt (Ví dụ, NguyenVanA_123456_Statistics.txt).
           - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
             <TenSinhVien_MaSinhVien_Statistics>.zip (Ví dụ, NguyenVanA_123456_Statistics.zip),
             nộp lên classroom.
         */
        TestStatistics test = new TestStatistics(null);
        System.out.println("=== Test MyArrayList ===");
        test.testMyArrayList();
        System.out.println("\n=== Test MyLinkedList ===");
        test.testMyLinkedList();
    }

    public void testMyArrayList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyArrayList, có các phần tử dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random random = new Random();

        int length = random.nextInt(21) + 30; // [30, 50]

        MyArrayList list = new MyArrayList();
        for (int i = 0; i < length; i++) {
            double val = 1 + 19 * random.nextDouble();
            val = Math.round(val * 100.0) / 100.0;
            list.add(val);
        }

        this.statistics = new Statistics(list);

        System.out.println("Dữ liệu ban đầu:");
        System.out.println(list);


        System.out.println("Dữ liệu sau khi sắp xếp:");
        System.out.println(list.sortIncreasing());

        System.out.println("Max = " + statistics.max());
        System.out.println("Min = " + statistics.min());
        System.out.println("Mean = " + statistics.mean());
        System.out.println("Variance = " + statistics.variance());

        double[] ranks = statistics.rank();
        System.out.println("Ranks:");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println();

        // Tìm kiếm một giá trị ngẫu nhiên trong dữ liệu
        double searchVal = 1 + 19 * random.nextDouble();
        searchVal = Math.round(searchVal * 100.0) / 100.0;
        int index = statistics.search(searchVal);
        System.out.println("Tìm kiếm giá trị " + searchVal + " trả về index: " + index);
    }

    public void testMyLinkedList() {
        /* TODO
           - Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu vào biến length.
           - Tạo một list kiểu MyLinkedList, có các phần tử lưu dữ liệu kiểu double được sinh ngẫu nhiên
             nằm trong đoạn [1, 20]. Tạo Statistics có dữ liệu là list dữ liệu vừa tạo, lưu vào statistics.
           - Sử dụng Statistics để tính các đại lượng thống kê cơ bản (max, min, kỳ vọng, phương sai, rank, sắp xếp, tìm kiếm).
             In ra terminal tập dữ liệu, tập dữ liệu được sắp xếp, các đại lượng thống kê và kết quả chức năng tìm kiếm.
         */
        Random random = new Random();

        int length = random.nextInt(21) + 30; // [30, 50]

        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < length; i++) {
            double val = 1 + 19 * random.nextDouble();
            val = Math.round(val * 100.0) / 100.0;
            list.add(val);
        }

        this.statistics = new Statistics(list);

        System.out.println("Dữ liệu ban đầu:");
        System.out.println(list);

        // Sắp xếp dữ liệu (giả sử MyLinkedList có method sort())
        list.sortIncreasing();

        System.out.println("Dữ liệu sau khi sắp xếp:");
        System.out.println(list.sortIncreasing());

        System.out.println("Max = " + statistics.max());
        System.out.println("Min = " + statistics.min());
        System.out.println("Mean = " + statistics.mean());
        System.out.println("Variance = " + statistics.variance());

        double[] ranks = statistics.rank();
        System.out.println("Ranks:");
        for (double r : ranks) {
            System.out.print(r + " ");
        }
        System.out.println();

        // Tìm kiếm một giá trị ngẫu nhiên trong dữ liệu
        double searchVal = 1 + 19 * random.nextDouble();
        searchVal = Math.round(searchVal * 100.0) / 100.0;
        int index = statistics.search(searchVal);
        System.out.println("Tìm kiếm giá trị " + searchVal + " trả về index: " + index);
    }
}
