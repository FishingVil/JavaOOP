package hus.oop.statistics;

public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayList() {
        data = new double[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    @Override
    public void add(double data) {
        /* TODO */
        if (size == this.data.length) {
            allocateMore();
        }
        this.data[size++] = data;
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == this.data.length) {
            allocateMore();
        }
        for (int i = size; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = data;
        size++;
    }

    @Override
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    @Override
    public MyArrayList sortIncreasing() {
        /* TODO */
        MyArrayList sortedList = new MyArrayList();
        for (int i = 0; i < size; i++) {
            sortedList.add(data[i]);
        }
        for (int i = 0; i < sortedList.size - 1; i++) {
            for (int j = i + 1; j < sortedList.size; j++) {
                if (sortedList.data[i] > sortedList.data[j]) {
                    double temp = sortedList.data[i];
                    sortedList.data[i] = sortedList.data[j];
                    sortedList.data[j] = temp;
                }
            }
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double target) {
        /* TODO */
        double[] tempData = new double[size];
        int[] originalIndices = new int[size];
        for (int i = 0; i < size; i++) {
            tempData[i] = data[i];
            originalIndices[i] = i;
        }

        // Sắp xếp tempData và đồng thời hoán đổi chỉ số tương ứng
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (tempData[i] > tempData[j]) {
                    double temp = tempData[i];
                    tempData[i] = tempData[j];
                    tempData[j] = temp;

                    int tempIdx = originalIndices[i];
                    originalIndices[i] = originalIndices[j];
                    originalIndices[j] = tempIdx;
                }
            }
        }

        // Binary Search trên tempData
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tempData[mid] == target) {
                return originalIndices[mid]; // Trả về chỉ số trong mảng gốc
            } else if (tempData[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Không tìm thấy
    }

    /**
     * Tạo iterator để có thể duyệt qua các phần tử của list.
     *
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyArrayListIterator(start);
    }

    /**
     * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
     */
    private void allocateMore() {
        /* TODO */
        double[] newData = new double[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        /**
         * Vị trí hiện tại của iterator trong MyArrayList.
         */
        private int currentPosition;

        /**
         * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
         */
        public MyArrayListIterator(int position) {
            /* TODO */
            this.currentPosition = position;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition < size;
        }

        @Override
        public Number next() {
            /* TODO */
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            /* TODO */
            if (currentPosition <= 0 || currentPosition > size) {
                throw new IllegalStateException();
            }
            MyArrayList.this.remove(--currentPosition);
        }
    }
}
