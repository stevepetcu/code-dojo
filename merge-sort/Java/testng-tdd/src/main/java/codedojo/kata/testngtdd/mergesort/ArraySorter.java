package codedojo.kata.testngtdd.mergesort;

import java.util.Arrays;

class ArraySorter {

    private ArraySortMerger arraySortMerger;

    ArraySorter() {
        arraySortMerger = new ArraySortMerger(); // could be injected, but these are tightly coupled anyway in the current implementation.
    }

    int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            int middle = arr.length / 2;

            int[] firstArray = Arrays.copyOf(arr, middle);
            int[] secondArray = Arrays.copyOfRange(arr, middle, arr.length);

            return arraySortMerger.merge(mergeSort(firstArray), mergeSort(secondArray));
        }

        return arr;
    }
}
