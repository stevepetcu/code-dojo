package codedojo.kata.testngtdd.mergesort;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ArraySortMergerTest {
    public void merge_WillReturnASortedArray_GivenTwoSortedIntegerArraysOfDifferentLengths() {
        // Given
        ArraySortMerger sortMerger = new ArraySortMerger();
        int[] first = new int[] {3, 5, 9, 20}, second = new int[] {1, 2, 4, 7, 15, 22};

        // Then
        Assert.assertEquals(sortMerger.merge(first, second), new int[] {1, 2, 3, 4, 5, 7, 9, 15, 20, 22});
    }
}
