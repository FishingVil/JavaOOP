package hus.oop.search;
import java.util.Random;
public class TestBinarySearch {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
          mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 3.0: 2

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]
          Binary search giá trị 6.0:-1

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
          nộp lên classroom
         */
        Random rand = new Random();

        // Sinh số nguyên ngẫu nhiên trong khoảng [20, 30]
        int size = 20 + rand.nextInt(11); // 20 + [0..10] = [20..30]

        // Tạo mảng double ngẫu nhiên kích thước size, giá trị trong khoảng [0.0, 100.0)
        double[] data = new double[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextDouble() * 100;
        }

        // Tạo đối tượng BinarySearch
        BinarySearch binarySearch = BinarySearch.getInstance();

        // Các thuật toán sắp xếp để test
        Sorter[] sorters = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort()
        };

        String[] sorterNames = {
                "Bubble Sort Algorithm",
                "Insertion Sort Algorithm",
                "Selection Sort Algorithm"
        };

        for (int i = 0; i < sorters.length; i++) {
            System.out.println("Using " + sorterNames[i] + ":");

            double[] copyData = new double[size];
            System.arraycopy(data, 0, copyData, 0, size);

            System.out.print("Before sorting: [");
            printArray(copyData);
            System.out.println("]");

            binarySearch.setSorter(sorters[i]);

            // Tạo giá trị cần tìm khác nhau cho mỗi thuật toán
            double valueToFind = rand.nextDouble() * 100;

            int index = binarySearch.search(copyData, valueToFind);

            System.out.print("After sorting: [");
            printArray(copyData);
            System.out.println("]");

            System.out.println("Binary search giá trị " + String.format("%.2f", valueToFind) + ": " + index);
            System.out.println();
        }
    }

    private static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(String.format("%.2f", arr[i]));
            if (i != arr.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
