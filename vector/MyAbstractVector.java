package hus.oop.vector;

public abstract class MyAbstractVector implements MyVector {
    /**
     * Mô tả vector theo định dạng [a1 a2 ... an]
     * @return
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(coordinate(i));
            if (i < size() - 1) {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();

    }

    /**
     * So sánh hai vector có bằng nhau không.
     * Hai vector bằng nhau nếu có cùng kích thước và có các phần tử bằng nhau.
     * @param another
     * @return
     */
    @Override
    public boolean equals(MyVector another) {
        /* TODO */
        if (another == null) {
            return false;
        }
        if (this.size() != another.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (this.coordinate(i) != another.coordinate(i)) {
                return false;
            }
        }
        return true;
    }
}
