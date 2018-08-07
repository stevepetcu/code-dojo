'use strict';

class ArrayMergeSorter {
    constructor() {
        this.sort = function (arr) {
            if (arr.length === 1) {
                return arr;
            }

            const middle = arr.length / 2;

            let firstHalf = arr.slice(0, middle), secondHalf = arr.slice(middle);

            return mergeSort(this.sort(firstHalf), this.sort(secondHalf));
        };

        let mergeSort = function (firstArr, secondArr) {
            let i = 0, j = 0, totalCount = firstArr.length + secondArr.length;
            let result = [];

            while (totalCount > 0) {
                if (i < firstArr.length && j < secondArr.length) {
                    if (firstArr[i] <= secondArr[j]) {
                        result.push(firstArr[i]);
                        ++i;
                    } else {
                        result.push(secondArr[j]);
                        ++j;
                    }
                } else if (i < firstArr.length) {
                    result.push(firstArr[i]);
                    ++i;
                } else {
                    result.push(secondArr[j]);
                    ++j;
                }

                --totalCount;
            }

            return result;
        };
    }
}

module.exports = ArrayMergeSorter;
