package hus.oop.fraction;

public class MyArrayDataSet implements MyDataSet {
    private static int DEFAULT_CAPACITY = 16;
    private MyFraction[] fractions;
    private int length;

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số có kích thước là DEFAULT_CAPACITY.
     */
    public MyArrayDataSet() {
        this.fractions = new MyFraction[DEFAULT_CAPACITY];
        this.length = 0;
    }

    /**
     * Hàm dựng khởi tạo mảng chứa các phân số truyền vào.
     * @param fractions
     */
    public MyArrayDataSet(MyFraction[] fractions) {
        this.fractions = new MyFraction[fractions.length];
        for (int i = 0; i < fractions.length; i++) {
            this.fractions[i] = fractions[i];
        }
        this.length = fractions.length;
    }

    /**
     * Phương thức chèn phân số fraction vào vị trí index.
     * Nếu index nằm ngoài đoạn [0, length] thì không chèn được vào.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction là một phân số.
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (!checkBoundaries(index, length)) {
            return false;
        }
        if (length >= fractions.length) {
            allocateMore();
        }
        for (int i = length; i > index; i--) {
            fractions[i] = fractions[i - 1];
        }
        fractions[index] = fraction;
        length++;
        return true;
    }

    /**
     * Phương thức thêm phân số fraction vào vị trí cuối cùng chưa có dữ liệu của mảng data.
     * Nếu mảng hết chỗ để thêm dữ liệu, mở rộng kích thước mảng gấp đôi.
     * @param fraction
     * @return true nếu chèn được số vào, false nếu không chèn được số vào.
     */
    @Override
    public boolean append(MyFraction fraction) {
        if (length >= fractions.length) {
            allocateMore();
        }
        fractions[length] = fraction;
        length++;
        return true;
    }

    @Override
    public MyArrayDataSet toSimplify() {
        MyFraction[] simplified = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            simplified[i] = new MyFraction(fractions[i]);
            simplified[i].simplify();
        }
        return new MyArrayDataSet(simplified);
    }


    @Override
    public MyArrayDataSet sortIncreasing() {
        MyFraction[] copied = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            copied[i] = fractions[i];
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (copied[i].compareTo(copied[j]) > 0 ||
                        (copied[i].compareTo(copied[j]) == 0 && copied[i].getDenominator() > copied[j].getDenominator())) {
                    MyFraction temp = copied[i];
                    copied[i] = copied[j];
                    copied[j] = temp;
                }
            }
        }
        return new MyArrayDataSet(copied);
    }

    @Override
    public MyArrayDataSet sortDecreasing() {
        MyFraction[] copied = new MyFraction[length];
        for (int i = 0; i < length; i++) {
            copied[i] = fractions[i];
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (copied[i].compareTo(copied[j]) < 0 ||
                        (copied[i].compareTo(copied[j]) == 0 && copied[i].getDenominator() < copied[j].getDenominator())) {
                    MyFraction temp = copied[i];
                    copied[i] = copied[j];
                    copied[j] = temp;
                }
            }
        }
        return new MyArrayDataSet(copied);
    }

    @Override
    public String myDataSetToString() {
        String result = "[";
        for (int i = 0; i < length; i++) {
            result += fractions[i];
            if (i < length - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    @Override
    public void print() {
        System.out.println(myDataSetToString());
    }

    /**
     * Phương thức mở rộng kích thước mảng gấp đôi, bằng cách tạo ra mảng mới có kích thước
     * gấp đôi, sau đó copy dự liệu từ mảng cũ vào.
     */
    private void allocateMore() {
        MyFraction[] newArray = new MyFraction[fractions.length * 2];
        for (int i = 0; i < fractions.length; i++) {
            newArray[i] = fractions[i];
        }
        fractions = newArray;
    }

    /**
     * Phương thức kiểm tra xem index có nằm trong khoảng [0, upperBound] hay không.
     * @param index
     * @param upperBound
     * @return true nếu index nằm trong khoảng [0, upperBound], false nếu ngược lại.
     */
    private boolean checkBoundaries(int index, int upperBound) {
        return index >= 0 && index <= upperBound;
    }
}
