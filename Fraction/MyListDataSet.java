package hus.oop.fraction;

import java.util.ArrayList;
import java.util.List;

public class MyListDataSet implements MyDataSet {
    private List<MyFraction> fractions;

    /**
     * Hàm dựng khởi tạo list chứa các phân số.
     */
    public MyListDataSet() {
        this.fractions = new ArrayList<MyFraction>();
    }

    /**
     * Hàm dựng khởi tạo list chứa các phân số theo truyền vào.
     * @param fractions
     */
    public MyListDataSet(List<MyFraction> fractions) {
        this.fractions = new ArrayList<MyFraction>();
        for (int i = 0; i < fractions.size(); i++) {
            this.fractions.add(fractions.get(i));
        }
    }

    @Override
    public boolean insert(MyFraction fraction, int index) {
        if (index < 0 || index > fractions.size()) {
            return false;
        }
        fractions.add(index, fraction);
        return true;
    }

    @Override
    public boolean append(MyFraction fraction) {
        fractions.add(fraction);
        return true;
    }

    @Override
    public MyListDataSet toSimplify() {
        List<MyFraction> simplified = new ArrayList<MyFraction>();
        for (int i = 0; i < fractions.size(); i++) {
            MyFraction f = new MyFraction(fractions.get(i));
            f.simplify();
            simplified.add(f);
        }
        return new MyListDataSet(simplified);
    }

    @Override
    public MyListDataSet sortIncreasing() {
        List<MyFraction> sorted = new ArrayList<MyFraction>();
        for (int i = 0; i < fractions.size(); i++) {
            sorted.add(fractions.get(i));
        }

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).compareTo(sorted.get(j)) > 0) {
                    MyFraction temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }

        return new MyListDataSet(sorted);
    }

    @Override
    public MyListDataSet sortDecreasing() {
        List<MyFraction> sorted = new ArrayList<MyFraction>();
        for (int i = 0; i < fractions.size(); i++) {
            sorted.add(fractions.get(i));
        }

        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(i).compareTo(sorted.get(j)) < 0) {
                    MyFraction temp = sorted.get(i);
                    sorted.set(i, sorted.get(j));
                    sorted.set(j, temp);
                }
            }
        }

        return new MyListDataSet(sorted);
    }

    @Override
    public String myDataSetToString() {
        String result = "[";
        for (int i = 0; i < fractions.size(); i++) {
            result += fractions.get(i).toString();
            if (i != fractions.size() - 1) {
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
}
