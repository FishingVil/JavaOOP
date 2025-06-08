package hus.oop.vector;

import java.util.LinkedList;
import java.util.List;

public class MyListVector extends MyAbstractVector {
    private List<Double> data;

    public MyListVector() {
        data = new LinkedList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public double coordinate(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(index);
    }

    @Override
    public double[] coordinates() {
        double[] arr = new double[data.size()];
        for (int i = 0; i < data.size(); i++) {
            arr[i] = data.get(i);
        }
        return arr;
    }

    @Override
    public MyListVector insert(double value) {
        data.add(value);
        return this;
    }

    @Override
    public MyListVector insert(double value, int index) {
        if (index < 0 || index > data.size()) {
            throw new IndexOutOfBoundsException();
        }
        data.add(index, value);
        return this;
    }

    @Override
    public MyListVector remove(int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException();
        }
        data.remove(index);
        return this;
    }

    @Override
    public MyListVector extract(int[] indices) {
        MyListVector result = new MyListVector();
        for (int idx : indices) {
            if (idx < 0 || idx >= data.size()) {
                throw new IndexOutOfBoundsException();
            }
            result.insert(data.get(idx));
        }
        return result;
    }

    @Override
    public void set(double value, int index) {
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException();
        }
        data.set(index, value);
    }

    @Override
    public MyListVector add(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) {
            result.insert(d + value);
        }
        return result;
    }

    @Override
    public MyListVector add(MyVector another) {
        if (another.size() != data.size()) {
            throw new IndexOutOfBoundsException();
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) + another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector addTo(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + value);
        }
        return this;
    }

    @Override
    public MyListVector addTo(MyVector another) {
        if (another.size() != data.size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) + another.coordinate(i));
        }
        return this;
    }

    @Override
    public MyListVector minus(double value) {
        MyListVector result = new MyListVector();
        for (Double d : data) {
            result.insert(d - value);
        }
        return result;
    }

    @Override
    public MyListVector minus(MyVector another) {
        if (another.size() != data.size()) {
            throw new IndexOutOfBoundsException();
        }
        MyListVector result = new MyListVector();
        for (int i = 0; i < data.size(); i++) {
            result.insert(data.get(i) - another.coordinate(i));
        }
        return result;
    }

    @Override
    public MyListVector minusFrom(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - value);
        }
        return this;
    }

    @Override
    public MyListVector minusFrom(MyVector another) {
        if (another.size() != data.size()) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) - another.coordinate(i));
        }
        return this;
    }

    @Override
    public double dot(MyVector another) {
        if (another.size() != data.size()) {
            throw new IndexOutOfBoundsException();
        }
        double sum = 0;
        for (int i = 0; i < data.size(); i++) {
            sum += data.get(i) * another.coordinate(i);
        }
        return sum;
    }

    @Override
    public MyListVector pow(double power) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, Math.pow(data.get(i), power));
        }
        return this;
    }

    @Override
    public MyListVector scale(double value) {
        for (int i = 0; i < data.size(); i++) {
            data.set(i, data.get(i) * value);
        }
        return this;
    }

    @Override
    public double norm() {
        double sum = 0;
        for (Double d : data) {
            sum += d * d;
        }
        return Math.sqrt(sum);
    }
}
