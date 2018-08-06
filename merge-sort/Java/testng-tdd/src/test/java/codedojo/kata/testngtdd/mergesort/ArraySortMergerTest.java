package codedojo.kata.testngtdd.mergesort;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test
public class ArraySortMergerTest {
    private ArraySortMerger subject;

    @BeforeSuite
    public void setUp() {
        subject = new ArraySortMerger();
    }

    public void merge_WillReturnASortedIntArray_GivenTwoSortedIntArraysAndFirstArrayShorter() {
        // Given
        int[] first = new int[]{3, 5, 9, 20}, second = new int[]{-4, 0, 1, 2, 7, 15, 22};

        // Then
        Assert.assertEquals(subject.merge(first, second), new int[]{-4, 0, 1, 2, 3, 5, 7, 9, 15, 20, 22});
    }

    public void merge_WillReturnASortedIntArray_GivenTwoSortedIntArraysAndFirstArrayLonger() {
        // Given
        int[] first = new int[]{-4, 0, 1, 2, 7, 15, 22}, second = new int[]{3, 5, 9, 20};

        // Then
        Assert.assertEquals(subject.merge(first, second), new int[]{-4, 0, 1, 2, 3, 5, 7, 9, 15, 20, 22});
    }
}
