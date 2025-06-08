package hus.oop.statistics;

public class MyLinkedList extends MyAbstractList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        top = null;
    }

    @Override
    public int size() {
        /* TODO */
        int count = 0;
        MyNode current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public void add(double data) {
        /* TODO */
        MyNode newNode = new MyNode(data);
        if (top == null) {
            top = newNode;
        } else {
            MyNode current = top;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    @Override
    public void insert(double data, int index) {
        /* TODO */
        int currentSize = size();
        if (index < 0 || index > currentSize) {
            throw new IndexOutOfBoundsException();
        }
        MyNode newNode = new MyNode(data);
        if (index == 0) {
            newNode.next = top;
            top = newNode;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    @Override
    public void remove(int index) {
        /* TODO */
        int currentSize = size();
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            top = top.next;
        } else {
            MyNode prev = getNodeByIndex(index - 1);
            prev.next = prev.next.next;
        }
    }

    @Override
    public MyLinkedList sortIncreasing() {
        /* TODO */
        MyLinkedList sortedList = new MyLinkedList();
        int currentSize = size();
        for (int i = 0; i < currentSize; i++) {
            sortedList.add(getNodeByIndex(i).data);
        }
        // Sắp xếp nổi bọt (bubble sort) đơn giản
        for (int i = 0; i < currentSize - 1; i++) {
            for (int j = i + 1; j < currentSize; j++) {
                double valI = sortedList.getNodeByIndex(i).data;
                double valJ = sortedList.getNodeByIndex(j).data;
                if (valI > valJ) {
                    // Hoán đổi dữ liệu
                    sortedList.getNodeByIndex(i).data = valJ;
                    sortedList.getNodeByIndex(j).data = valI;
                }
            }
        }
        return sortedList;
    }

    @Override
    public int binarySearch(double data) {
        /* TODO */
        int n = size();
        double[] values = new double[n];
        int[] indices = new int[n];

        // Bước 1: Đọc toàn bộ node vào mảng và lưu chỉ số gốc
        MyNode current = top;
        for (int i = 0; i < n; i++) {
            values[i] = current.data;
            indices[i] = i;
            current = current.next;
        }

        // Bước 2: Sắp xếp values[] và hoán đổi indices[] tương ứng
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (values[i] > values[j]) {
                    double tempVal = values[i];
                    values[i] = values[j];
                    values[j] = tempVal;

                    int tempIdx = indices[i];
                    indices[i] = indices[j];
                    indices[j] = tempIdx;
                }
            }
        }

        // Bước 3: Thực hiện Binary Search trên mảng đã sắp
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (values[mid] == data) {
                return indices[mid]; // trả về index trong danh sách gốc
            } else if (values[mid] < data) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Không tìm thấy
    }

    /**
     * Tạo iterator để cho phép duyệt qua các phần tử của list.
     *
     * @return
     */
    @Override
    public MyIterator iterator(int start) {
        /* TODO */
        return new MyLinkedListIterator(start);
    }

    /**
     * Lấy node ở vị trí index.
     *
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        int currentSize = size();
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        MyNode current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        /*
         * Vị trí hiện tại của iterator trong list.
         */
        private int currentPosition;

        /**
         * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
         *
         * @param position
         */
        public MyLinkedListIterator(int position) {
            /* TODO */
            int currentSize = size();
            if (position < 0 || position > currentSize) {
                throw new IndexOutOfBoundsException();
            }
            currentPosition = position;
            currentNode = (position == currentSize) ? null : getNodeByIndex(position);
            lastReturned = null;
            prevNode = null;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentNode != null;
        }

        @Override
        public Number next() {
            /* TODO */
            if (currentNode == null) {
                throw new java.util.NoSuchElementException();
            }
            double val = currentNode.data;
            prevNode = lastReturned;
            lastReturned = currentNode;
            currentNode = currentNode.next;
            currentPosition++;
            return val;
        }

        @Override
        public void remove() {
            /* TODO */
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            if (lastReturned == top) {
                top = top.next;
            } else {
                if (prevNode != null) {
                    prevNode.next = lastReturned.next;
                }
            }
            lastReturned = null;
            currentPosition--;
        }

        private MyNode currentNode;
        private MyNode lastReturned;
        private MyNode prevNode;
    }

    private static class MyNode {
        double data;
        MyNode next;

        MyNode(double data) {
            this.data = data;
            this.next = null;
        }
    }
}
