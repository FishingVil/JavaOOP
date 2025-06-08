package hus.oop.statistics;

public class Statistics {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public Statistics(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     *
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("Empty list");
        MyIterator iterator = data.iterator(0);
        double maxVal = (double) iterator.next();
        while (iterator.hasNext()) {
            double val = (double) iterator.next();
            if (val > maxVal) {
                maxVal = val;
            }
        }
        return maxVal;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     *
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("Empty list");
        MyIterator iterator = data.iterator(0);
        double minVal = (double) iterator.next();
        while (iterator.hasNext()) {
            double val = (double) iterator.next();
            if (val < minVal) {
                minVal = val;
            }
        }
        return minVal;
    }

    /**
     * Tính kỳ vọng của mẫu theo dữ liệu trong list.
     *
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        if (data.size() == 0) throw new IllegalStateException("Empty list");
        MyIterator iterator = data.iterator(0);
        double sum = 0.0;
        int count = 0;
        while (iterator.hasNext()) {
            sum += (double) iterator.next();
            count++;
        }
        return sum / count;
    }

    /**
     * Tính phương sai của mẫu theo dữ liệu trong list.
     *
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        int n = data.size();
        if (n < 2) throw new IllegalStateException("Not enough data");
        double meanVal = mean();
        MyIterator iterator = data.iterator(0);
        double sumSqDiff = 0.0;
        while (iterator.hasNext()) {
            double val = (double) iterator.next();
            sumSqDiff += Math.pow(val - meanVal, 2);
        }
        return sumSqDiff / (n - 1);
    }

    /**
     * Tìm kiếm trong list có phẩn tử nào có giá trị bằng data không, sử dụng binarySearch trong list.
     * Trả về index một phần tử có giá trị bằng data, nếu không tìm thấy thì trả về -1.
     *
     * @return
     */
    public int search(double data) {
        /* TODO */
        return this.data.binarySearch(data);
    }

    /**
     * Tính rank của các phần tử trong list.
     *
     * @return rank của các phần tử trong list
     */
    public double[] rank() {
        /* TODO */
        int n = data.size();
        double[] values = new double[n];
        MyIterator iterator = data.iterator(0);
        for (int i = 0; i < n; i++) {
            values[i] = (double) iterator.next();
        }

        double[] ranks = new double[n];

        for (int i = 0; i < n; i++) {
            int lessCount = 0;    // số phần tử nhỏ hơn values[i]
            int equalCount = 0;   // số phần tử bằng values[i]

            for (int j = 0; j < n; j++) {
                if (values[j] < values[i]) {
                    lessCount++;
                } else if (values[j] == values[i]) {
                    equalCount++;
                }
            }

            // Rank trung bình = vị trí trung bình của tất cả phần tử bằng nhau:
            // lessCount + 1 là rank nhỏ nhất trong nhóm bằng nhau
            // equalCount là số phần tử bằng nhau
            // rank trung bình = lessCount + (1 + equalCount) / 2.0
            ranks[i] = lessCount + (equalCount + 1) / 2.0;
        }

        return ranks;
    }
}
