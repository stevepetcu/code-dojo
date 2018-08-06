package codedojo.kata.testngtdd.mergesort;

import java.util.Arrays;

public class Main {
    private static ArraySorter arraySorter;

    static {
        arraySorter = new ArraySorter();
    }

    public static void main(String... args) {
        int[] arr = new int[] {10, 5, 1, -2, 15, 23, 3, 6, 12, 9, 11};

        System.out.println(Arrays.toString(arraySorter.mergeSort(arr)));
    }
}
