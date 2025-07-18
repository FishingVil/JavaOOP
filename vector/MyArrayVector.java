package hus.oop.vector;

public class MyArrayVector extends MyAbstractVector {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo mặc định cho vector.
     */
    public MyArrayVector() {
        /* TODO */
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public double coordinate(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public double[] coordinates() {
        /* TODO */
        double[] copy = new double[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    @Override
    public MyArrayVector insert(double value) {
        /* TODO */
        if (size == data.length) {
            allocateMore();
        }
        data[size] = value;
        size += 1;
        return this;
    }

    @Override
    public MyArrayVector insert(double value, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return this;
    }

    @Override
    public MyArrayVector remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size -= 1;
        return this;
    }

    @Override
    public MyArrayVector extract(int[] indices) {
        /* TODO */
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] <= 0 || indices[i] > size) {
                throw new IndexOutOfBoundsException("Invalid index: " + indices[i]);
            }
        }
        MyArrayVector extractVector = new MyArrayVector();
        for (int i = 0; i < indices.length; i++) {
            extractVector.insert(data[indices[i] - 1]);
        }
        return extractVector;
    }

    @Override
    public void set(double value, int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    @Override
    public MyArrayVector add(double value) {
        /* TODO */
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + value);
        }
        return result;
    }

    @Override
    public MyArrayVector add(MyVector another) {
        /* TODO */
        if (size != another.size()) {
            throw new IndexOutOfBoundsException();
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector addTo(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] += value;
        }
        return this;
    }

    @Override
    public MyArrayVector addTo(MyVector another) {
        /* TODO */
        if (size != another.size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            data[i] += another.coordinate(i);
        }
        return this;
    }

    @Override
    public MyArrayVector minus(double value) {
        /* TODO */
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - value);
        }
        return result;
    }

    @Override
    public MyArrayVector minus(MyVector another) {
        /* TODO */
        if (size != another.size()) {
            throw new IndexOutOfBoundsException();
        }
        MyArrayVector result = new MyArrayVector();
        for (int i = 0; i < size; i++) {
            result.insert(data[i] - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyArrayVector minusFrom(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] -= value;
        }
        return this;
    }

    @Override
    public MyArrayVector minusFrom(MyVector another) {
        /* TODO */
        if (size != another.size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < size; i++) {
            data[i] -= another.coordinate(i);
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        /* TODO */
        if (size != another.size()) {
            throw new IndexOutOfBoundsException();
        }
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * another.coordinate(i);
        }
        return result;
    }

    @Override
    public MyArrayVector pow(double power) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] = Math.pow(data[i], power);
        }
        return this;
    }

    @Override
    public MyArrayVector scale(double value) {
        /* TODO */
        for (int i = 0; i < size; i++) {
            data[i] *= value;
        }
        return this;
    }

    @Override
    public double norm() {
        /* TODO */
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += data[i] * data[i];
        }
        return Math.sqrt(result);
    }

    /**
     * Mở rộng kích thước vector lên gấp đôi khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        int newCapacity = Math.max(1, data.length * 2);
        double[] copy = new double[newCapacity];
        System.arraycopy(data, 0, copy, 0, size);
        data = copy;
    }
}
