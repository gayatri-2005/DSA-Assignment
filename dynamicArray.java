// import java.util.Arrays;

// public class DA{
// public class DynamicArray {
//     private int[] arr;
//     private int size;
//     private int cap;
//     private int resizeFactor;

//     public DynamicArray(int firstCapacity, int resizeFactor) {
//         if (firstCapacity <= 0) throw new IllegalArgumentException("Initial capacity must be greater than 0");
//         if (resizeFactor <= 1) throw new IllegalArgumentException("Resize factor must be greater than 1");

//         this.cap = firstCapacity;
//         this.resizeFactor = resizeFactor;
//         this.arr = new int[firstCapacity];
//         this.size = 0;
//     }

//     // Inserts an element at the specified index
//     public void insert(int idx, int elmt) {
//         if (idx < 0 || idx > size) throw new IndexOutOfBoundsException("Index out of bounds");
//         if (size == cap) resize();
//         for (int i = size; i > idx; i--) {
//             arr[i] = arr[i - 1];
//         }
//         arr[idx] = elmt;
//         size++;
//     }

//     // Deletes the element at the specified index
//     public void delete(int idx) {
//         if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index out of bounds");
//         for (int i = idx; i < size - 1; i++) {
//             arr[i] = arr[i + 1];
//         }
//         size--;
//     }

//     // Returns size of dynamic array
//     public int size() {
//         return size;
//     }

//     // Returns true if  dynamic array is empty, false in other condititons
//     public boolean isEmpty() {
//         return size == 0;
//     }

//     // Rotates the dynamic array by k positions to the right(like left shift)
//     public void rotate(int k) {
//         if (size == 0) return;
//         k = k % size;
//         reverse(0, size - 1);
//         reverse(0, k - 1);
//         reverse(k, size - 1);
//     }

//     // Reverses the dynamic array
//     public void reversearray() {
//         reverse(0, size - 1);
//     }

//     private void reverse(int start, int end) {
//         while (start < end) {
//             int temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;
//             start++;
//             end--;
//         }
//     }

//     // Appends an element to the end of the dynamic array
//     public void append(int elmt) {
//         if (size == cap) resize();
//         arr[size++] = elmt;
//     }

//     // Prepends an element to the beginning of the dynamic array
//     public void prepend(int elmt) {
//         insert(0, elmt);
//     }

//     // Merges two dynamic arrays into a single array
//     public void merge(DynamicArray other) {
//         while (size + other.size > cap) resize();
//         for (int i = 0; i < other.size; i++) {
//             arr[size++] = other.arr[i];
//         }
//     }

//     // Interleaves two dynamic arrays into a single dynamic array
//     public static DynamicArray interleave(DynamicArray a, DynamicArray b) {
//         DynamicArray result = new DynamicArray(a.size + b.size, Math.max(a.resizeFactor, b.resizeFactor));
//         int i = 0, j = 0;
//         while (i < a.size || j < b.size) {
//             if (i < a.size) result.append(a.arr[i++]);
//             if (j < b.size) result.append(b.arr[j++]);
//         }
//         return result;
//     }

//     // Returns the middle element of the dynamic array
//     public int middle() {
//         if (size == 0) throw new IllegalStateException("Array is empty");
//         return arr[size / 2]; 
//     }

//     // Returns the index of the first occurrence of the specified element in the dynamic array, or -1 if not found
//     public int indexOf(int element) {
//         for (int i = 0; i < size; i++) {
//             if (arr[i] == element) return i;
//         }
//         return -1;
//     }

//     // Splits the dynamic array into two dynamic arrays at the specified index
//     public DynamicArray[] split(int idx) {
//         if (idx < 0 || idx > size) throw new IndexOutOfBoundsException("Index out of bounds");

//         DynamicArray first = new DynamicArray(idx, resizeFactor);
//         DynamicArray second = new DynamicArray(size - idx, resizeFactor);

//         for (int i = 0; i < idx; i++) {
//             first.append(arr[i]);
//         }
//         for (int i = idx; i < size; i++) {
//             second.append(arr[i]);
//         }

//         return new DynamicArray[]{first, second};
//     }

//     // Resizes the dynamic array based on the resize factor
//     private void resize() {
//         cap *= resizeFactor;
//         arr = Arrays.copyOf(arr, cap);
//     }

//     // Displays the array contents
//     public void display() {
//         for (int i = 0; i < size; i++) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         DynamicArray arr = new DynamicArray(5, 3);
//         arr.append(1);
//         arr.append(2);
//         arr.append(3);
//         arr.append(4);
//         arr.append(5);
//         arr.display();

//         arr.prepend(0);
//         arr.display();

//         arr.insert(3, 10);
//         arr.display();

//         arr.delete(2);
//         arr.display();

//         System.out.println("Size: " + arr.size());
//         System.out.println("Is empty: " + arr.isEmpty());

//         arr.rotate(2);
//         arr.display();

//         arr.reversearray();
//         arr.display();

//         DynamicArray arr2 = new DynamicArray(3, 2);
//         arr2.append(6);
//         arr2.append(7);
//         arr2.append(8);
//         arr.merge(arr2);
//         arr.display();

//         DynamicArray interleaved = DynamicArray.interleave(arr, arr2);
//         interleaved.display();

//         System.out.println("Middle element: " + arr.middle());

//         System.out.println("Index of 10: " + arr.indexOf(10));

//         DynamicArray[] splitArr = arr.split(5);
//         splitArr[0].display();
//         splitArr[1].display();
//     }
// }
// }


import java.util.Arrays;
public class dynamicArray{
public class DynamicArray {
    private int[] arr;
    private int size;
    private int cap;
    private int resizeFactor;

    public DynamicArray(int firstCapacity, int resizeFactor) {
        if (firstCapacity <= 0) throw new IllegalArgumentException("Initial capacity must be greater than 0");
        if (resizeFactor <= 1) throw new IllegalArgumentException("Resize factor must be greater than 1");

        this.cap = firstCapacity;
        this.resizeFactor = resizeFactor;
        this.arr = new int[firstCapacity];
        this.size = 0;
    }

    // Inserts an element at the specified index
    public void insert(int idx, int elmt) {
        if (idx < 0 || idx > size) throw new IndexOutOfBoundsException("Index out of bounds");
        if (size == cap) resize();
        for (int i = size; i > idx; i--) {
            arr[i] = arr[i - 1];
        }
        arr[idx] = elmt;
        size++;
    }

    // Deletes the element at the specified index
    public void delete(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        for (int i = idx; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // Returns size of dynamic array
    public int size() {
        return size;
    }

    // Returns true if dynamic array is empty, false in other conditions
    public boolean isEmpty() {
        return size == 0;
    }

    // Rotates the dynamic array by k positions to the right (like left shift)
    public void rotate(int k) {
        if (size == 0) return;
        k = k % size;
        if (k == 0) return;
        reverse(0, size - 1);
        reverse(0, k - 1);
        reverse(k, size - 1);
    }

    // Reverses the dynamic array
    public void reversearray() {
        reverse(0, size - 1);
    }

    private void reverse(int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Appends an element to the end of the dynamic array
    public void append(int elmt) {
        if (size == cap) resize();
        arr[size++] = elmt;
    }

    // Prepends an element to the beginning of the dynamic array
    public void prepend(int elmt) {
        insert(0, elmt);
    }

    // Merges two dynamic arrays into a single array
    public void merge(DynamicArray other) {
        while (size + other.size > cap) resize();
        for (int i = 0; i < other.size; i++) {
            arr[size++] = other.arr[i];
        }
    }

    // Interleaves two dynamic arrays into a single dynamic array
    public static DynamicArray interleave(DynamicArray a, DynamicArray b) {
        DynamicArray result = new DynamicArray(a.size + b.size, Math.max(a.resizeFactor, b.resizeFactor));
        int i = 0, j = 0;
        while (i < a.size || j < b.size) {
            if (i < a.size) result.append(a.arr[i++]);
            if (j < b.size) result.append(b.arr[j++]);
        }
        return result;
    }

    // Returns the middle element of the dynamic array
    public int middle() {
        if (size == 0) throw new IllegalStateException("Array is empty");
        return arr[size / 2];
    }

    // Returns the index of the first occurrence of the specified element in the dynamic array, or -1 if not found
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }

    // Splits the dynamic array into two dynamic arrays at the specified index
    public DynamicArray[] split(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException("Index out of bounds");

        DynamicArray first = new DynamicArray(idx, resizeFactor);
        DynamicArray second = new DynamicArray(size - idx, resizeFactor);

        for (int i = 0; i < idx; i++) {
            first.append(arr[i]);
        }
        for (int i = idx; i < size; i++) {
            second.append(arr[i]);
        }

        return new DynamicArray[]{first, second};
    }

    // Resizes the dynamic array based on the resize factor
    private void resize() {
        cap *= resizeFactor;
        arr = Arrays.copyOf(arr, cap);
    }

    // Displays the array contents
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(5, 3);
        arr.append(1);
        arr.append(2);
        arr.append(3);
        arr.append(4);
        arr.append(5);
        arr.display();

        arr.prepend(0);
        arr.display();

        arr.insert(3, 10);
        arr.display();

        arr.delete(2);
        arr.display();

        System.out.println("Size: " + arr.size());
        System.out.println("Is empty: " + arr.isEmpty());

        arr.rotate(2);
        arr.display();

        arr.reversearray();
        arr.display();

        DynamicArray arr2 = new DynamicArray(3, 2);
        arr2.append(6);
        arr2.append(7);
        arr2.append(8);
        arr.merge(arr2);
        arr.display();

        DynamicArray interleaved = DynamicArray.interleave(arr, arr2);
        interleaved.display();

        System.out.println("Middle element: " + arr.middle());

        System.out.println("Index of 10: " + arr.indexOf(10));

        DynamicArray[] splitArr = arr.split(5);
        splitArr[0].display();
        splitArr[1].display();
    }
}
}
```

