package hus.oop.mybookmanager;

public class BookManager {
    private static BookManager instance;
    private MyList bookList;

    private BookManager() {
        bookList = new MyLinkedList();
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
        }
        return instance;
    }

    public MyList getBookList() {
        return bookList;
    }

    /**
     * Thêm book vào đầu danh sách.
     * @param book
     */
    public void insertAtStart(Book book) {
        bookList.insertAtStart(book);
    }

    /**
     * Thêm book vào cuối danh sách.
     * @param book
     */
    public void insertAtEnd(Book book) {
        bookList.insertAtEnd(book);
    }

    /**
     * Thêm book vào danh sách ở vị trí index.
     * @param book
     * @param index
     */
    public void insertAPosition(Book book, int index) {
        bookList.insertAtPosition(book, index);
    }

    /**
     * Xóa book ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        bookList.remove(index);
    }

    /**
     * Lấy ra book ở vị trí index
     * @param index
     * @return
     */
    public Book bookAt(int index) {
        MyIterator iterator = bookList.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Object current = iterator.next();
            if (count == index) {
                return (Book) current;
            }
            count++;
        }
        throw new IndexOutOfBoundsException("Index: " + index);
    }

    /**
     * Lấy ra sách có giá cao nhất.
     * @return
     */
    public Book highestPriceBook() {
        if (bookList.size() == 0) return null;

        MyIterator it = bookList.iterator();
        Book maxBook = (Book) it.next();
        while (it.hasNext()) {
            Book current = (Book) it.next();
            if (current.getPrice() > maxBook.getPrice()) {
                maxBook = current;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có giá thấp nhất.
     * @return
     */
    public Book lowestPriceBook() {
        if (bookList.size() == 0) return null;

        MyIterator it = bookList.iterator();
        Book minBook = (Book) it.next();
        while (it.hasNext()) {
            Book current = (Book) it.next();
            if (current.getPrice() < minBook.getPrice()) {
                minBook = current;
            }
        }
        return minBook;
    }

    /**
     * Lấy ra sách có số trang cao nhất.
     * @return
     */
    public Book highestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;

        MyIterator it = bookList.iterator();
        Book maxBook = (Book) it.next();
        while (it.hasNext()) {
            Book current = (Book) it.next();
            if (current.getPages() > maxBook.getPages()) {
                maxBook = current;
            }
        }
        return maxBook;
    }

    /**
     * Lấy ra sách có số trang thấp nhất.
     * @return
     */
    public Book lowestNumberOfPagesBook() {
        if (bookList.size() == 0) return null;

        MyIterator it = bookList.iterator();
        Book minBook = (Book) it.next();
        while (it.hasNext()) {
            Book current = (Book) it.next();
            if (current.getPages() < minBook.getPages()) {
                minBook = current;
            }
        }
        return minBook;
    }

    /**
     * Lọc ra những book theo nhà xuất bản.
     * @param publisher
     * @return
     */
    public MyList filterBooksOfPublisher(String publisher) {
        MyList filtered = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getPublisher() != null && book.getPublisher().equals(publisher)) {
                filtered.insertAtEnd(book);
            }
        }
        return filtered;
    }

    /**
     * Lọc ra những book theo thể loại.
     * @param genre
     * @return
     */
    public MyList filterBooksOfGenre(String genre) {
        MyList filtered = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getGenre() != null && book.getGenre().equals(genre)) {
                filtered.insertAtEnd(book);
            }
        }
        return filtered;
    }

    /**
     * Lọc ra những book theo tác giả.
     * @param author
     * @return
     */
    public MyList filterBooksOfAuthor(String author) {
        MyList filtered = new MyLinkedList();
        MyIterator it = bookList.iterator();
        while (it.hasNext()) {
            Book book = (Book) it.next();
            if (book.getAuthor() != null && book.getAuthor().equals(author)) {
                filtered.insertAtEnd(book);
            }
        }
        return filtered;
    }
}
