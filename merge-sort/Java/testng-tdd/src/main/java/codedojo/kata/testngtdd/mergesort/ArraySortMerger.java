package codedojo.kata.testngtdd.mergesort;

class ArraySortMerger {
    int[] merge(int[] firstPart, int[] secondPart) {
        int i = 0, j = 0, resultIndex = 0, totalCount = firstPart.length + secondPart.length;
        int[] result = new int[totalCount];

        while (i < firstPart.length || j < secondPart.length) {
            if (i < firstPart.length && firstPart[i] <= secondPart[j]) {
                result[resultIndex] = firstPart[i];
                ++i;
            } else {
                result[resultIndex] = secondPart[j];
                ++j;
            }
            ++resultIndex;
        }

        return result;
    }
}
