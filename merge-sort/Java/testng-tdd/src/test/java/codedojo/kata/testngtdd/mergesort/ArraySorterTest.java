package codedojo.kata.testngtdd.mergesort;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySorterTest {
    @Test
    public void mergeSort_WillReturnASortedIntArray_GivenAnUnsortedIntArray() {
        // Given
        ArraySorter subject = new ArraySorter();
        int[] randomIntArray = new int[]{10, 5, 1, -2, 15, 23, 3, 6, 12, 9, 11};

        // Then
        Assert.assertEquals(
                subject.mergeSort(randomIntArray),
                new int[]{-2, 1, 3, 5, 6, 9, 10, 11, 12, 15, 23}
        );
    }
}
