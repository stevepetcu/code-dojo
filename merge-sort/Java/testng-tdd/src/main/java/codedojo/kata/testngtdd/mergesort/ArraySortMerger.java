package codedojo.kata.testngtdd.mergesort;

class ArraySortMerger {
    /**
     * Merges arrays' elements in sorted, ascending order. Array's elements
     * must already be sorted, lest the outcome is unpredictable.
     *
     * @param firstPart  The first array.
     * @param secondPart The second array.
     * @return int[]
     */
    int[] merge(int[] firstPart, int[] secondPart) {
        int i = 0, j = 0, resultIndex = 0, totalCount = firstPart.length + secondPart.length;
        int[] result = new int[totalCount];

        while (resultIndex <= totalCount - 1) {
            if (i < firstPart.length && j < secondPart.length) {
                if (firstPart[i] <= secondPart[j]) {
                    result[resultIndex] = firstPart[i];
                    ++i;
                } else {
                    result[resultIndex] = secondPart[j];
                    ++j;
                }
            } else if (i == firstPart.length) {
                result[resultIndex] = secondPart[j];
                ++j;
            } else {
                result[resultIndex] = firstPart[i];
                ++i;
            }

            ++resultIndex;
        }

        return result;
    }
}
