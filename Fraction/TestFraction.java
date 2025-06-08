package hus.oop.fraction;

import java.util.Random;

public class TestFraction {
    private MyDataSet myDataSet;

    public TestFraction(MyDataSet myDataSet) {
        this.myDataSet = myDataSet;
    }

    public static void main(String[] args) {
        TestFraction arrayTester = new TestFraction(null);
        arrayTester.testMyArrayDataSet();

        TestFraction listTester = new TestFraction(null);
        listTester.testMyListDataSet();
    }

    public void testMyArrayDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyArrayDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */

        Random rand = new Random();
        int numbers = rand.nextInt(21) + 30;
        MyFraction[] array = new MyFraction[numbers];
        for (int i = 0; i < numbers; i++) {
            int num = rand.nextInt(100) + 1;
            int den = rand.nextInt(100) + 1;
            array[i] = new MyFraction(num, den);
        }

        myDataSet = new MyArrayDataSet(array);
        System.out.println("Original dataset:");
        myDataSet.print();

        System.out.println("\nSorted increasing:");
        myDataSet.sortIncreasing().print();

        System.out.println("\nSorted decreasing:");
        myDataSet.sortDecreasing().print();

        System.out.println("\nSimplified (original order):");
        myDataSet.toSimplify().print();

        System.out.println("\nSimplified increasing:");
        myDataSet.toSimplify().sortIncreasing().print();

        System.out.println("\nSimplified decreasing:");
        myDataSet.toSimplify().sortDecreasing().print();
    }

    public void testMyListDataSet() {
        /* TODO
        1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [30, 50], lưu giá trị vào biến numbers.
        2. Tạo ra numbers phân số, trong đó tử số và mẫu số được sinh ngẫu nhiên là các số tự nhiên nằm trong đoạn [1, 100].
           Lưu các phân số vào trong một tập dữ liệu myDataSet dùng MyListDataSet.

        3. Sắp xếp và in ra tập dữ liệu đã tạo ra theo các tiêu chí sau:
             - In ra các phân số theo thứ tự có giá trị tăng dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị tăng dần của mẫu số.
             - In ra các phân số theo thứ tự có giá trị giảm dần, nếu phân số bằng nhau thì được sắp xếp theo thứ tự
               có giá trị giảm dần của mẫu số.

         4. In ra các dữ liệu sau:
             - In ra các phân số tối giản của các phân số đã tạo ra theo thứ tự trong dữ liệu gốc.
             - In ra các phân số tối giản theo thứ tự tăng dần.
             - In ra các phân số tối giản theo thứ tự giảm dần.
        */

        Random rand = new Random();
        int numbers = rand.nextInt(21) + 30;
        MyListDataSet listDataSet = new MyListDataSet();

        for (int i = 0; i < numbers; i++) {
            int num = rand.nextInt(100) + 1;
            int den = rand.nextInt(100) + 1;
            listDataSet.append(new MyFraction(num, den));
        }

        myDataSet = listDataSet;

        System.out.println("Original dataset:");
        myDataSet.print();

        System.out.println("\nSorted increasing:");
        myDataSet.sortIncreasing().print();

        System.out.println("\nSorted decreasing:");
        myDataSet.sortDecreasing().print();

        System.out.println("\nSimplified (original order):");
        myDataSet.toSimplify().print();

        System.out.println("\nSimplified increasing:");
        myDataSet.toSimplify().sortIncreasing().print();

        System.out.println("\nSimplified decreasing:");
        myDataSet.toSimplify().sortDecreasing().print();
    }
}
