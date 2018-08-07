'use strict';

const should = require('chai').should();

const ArrayMergeSorter = require('../../../src/merge-sort/service/array-merge-sorter');

describe('Sorting an array of integers.', function () {
    it('should return a sorted integer array when sort is called, given an unsorted integer array', function () {
        let arraySorter = new ArrayMergeSorter();
        let unsortedArray = [10, 3, 5, 0, -5, 20, 15, -10, 22, -2, 11];

        arraySorter.sort(unsortedArray).should.equal([-10, -5, -2, 0, 3, 5, 10, 11, 15, 20, 22]);
    })
});
