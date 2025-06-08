package hus.oop.mybookmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_MyBookManager>.txt (Ví dụ, NguyenVanA_123456_MyBookManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_BookMyManager>.zip (Ví dụ, NguyenVanA_123456_BookMyManager.zip),
          nộp lên classroom.
         */

        System.out.println("=== Test original data ===");
        testOriginalData();

        System.out.println("\n=== Test filter books of author ===");
        testFilterBooksOfAuthor();

        System.out.println("\n=== Test filter books of publisher ===");
        testFilterBooksOfPublisher();

        System.out.println("\n=== Test filter books of genre ===");
        testFilterBooksOfGenre();

        System.out.println("\n=== Test get highest price book ===");
        testGetHighestPriceBook();

        System.out.println("\n=== Test get lowest price book ===");
        testGetLowestPriceBook();

        System.out.println("\n=== Test get highest number of pages book ===");
        testGetHighestNumberOfPagesBook();

        System.out.println("\n=== Test get lowest number of pages book ===");
        testGetLowestNumberOfPagesBook();
    }

    public static void init() {
        String filePath = "data/books.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("title")) {
                    continue;
                }

                /*
                TODO
                Đọc được dữ liệu, tạo ra các đối tượng Book ở đây, và cho vào BookManager để quản lý.

                Gợi ý:
                Các đội tượng Book không thể được tạo trực tiếp ở đây do hàm dựng là private,
                các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                Book newBook = new Book.BookBuilder(title).
                    .withAuthor(author)
                    .withGenre(genre)
                    ...
                    .build();
                */
                String title = dataList.get(0);
                String author = dataList.get(1);
                String genre = dataList.get(2);
                String publisher = dataList.get(3);
                int pages = Integer.parseInt(dataList.get(4));
                double price = Double.parseDouble(dataList.get(5));

                Book newBook = new Book.BookBuilder(title)
                        .withAuthor(author)
                        .withGenre(genre)
                        .withPublisher(publisher)
                        .withPages(pages)
                        .withPrice(price)
                        .build();

                BookManager.getInstance().insertAtEnd(newBook);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    /**
     * Phương thức trợ giúp để in ra một danh sách sách.
     *
     * @param bookList
     */
    public static void printList(MyList bookList) {
        if (bookList == null || bookList.size() == 0) {
            System.out.println("No books found matching the criteria.");
            return;
        }
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void testOriginalData() {
        MyList bookList = BookManager.getInstance().getBookList();
        printList(bookList);
    }

    /**
     * Test lọc ra những book theo tác giả.
     */
    public static void testFilterBooksOfAuthor() {
        /* TODO */
        String author = "George R.R. Martin";
        System.out.println("Filtering books by author: " + author);
        MyList filteredBooks = BookManager.getInstance().filterBooksOfAuthor(author);
        printList(filteredBooks);
    }

    /**
     * Test lọc ra những book theo nhà xuất bản.
     */
    public static void testFilterBooksOfPublisher() {
        /* TODO */
        String publisher = "Bantam Books";
        System.out.println("Filtering books by publisher: " + publisher);
        MyList filteredBooks = BookManager.getInstance().filterBooksOfPublisher(publisher);
        printList(filteredBooks);
    }

    /**
     * Test lọc ra những book theo thể loại.
     */
    public static void testFilterBooksOfGenre() {
        /* TODO */
        String genre = "Epic fantasy";
        System.out.println("Filtering books by genre: " + genre);
        MyList filteredBooks = BookManager.getInstance().filterBooksOfGenre(genre);
        printList(filteredBooks);
    }

    /**
     * Test lấy ra sách có giá cao nhất.
     */
    public static void testGetHighestPriceBook() {
        Book highestPriceBook = BookManager.getInstance().highestPriceBook();
        System.out.println("Book with the highest price:");
        System.out.println(highestPriceBook);
    }

    /**
     * Test lấy ra sách có giá thấp nhất.
     */
    public static void testGetLowestPriceBook() {
        Book lowestPriceBook = BookManager.getInstance().lowestPriceBook();
        System.out.println("Book with the lowest price:");
        System.out.println(lowestPriceBook);
    }

    /**
     * Test lấy ra sách có số trang cao nhất.
     */
    public static void testGetHighestNumberOfPagesBook() {
        Book highestPagesBook = BookManager.getInstance().highestNumberOfPagesBook();
        System.out.println("Book with the highest number of pages:");
        System.out.println(highestPagesBook);
    }

    /**
     * Test lấy ra sách có số trang thấp nhất.
     */
    public static void testGetLowestNumberOfPagesBook() {
        Book lowestPagesBook = BookManager.getInstance().lowestNumberOfPagesBook();
        System.out.println("Book with the lowest number of pages:");
        System.out.println(lowestPagesBook);
    }
}
