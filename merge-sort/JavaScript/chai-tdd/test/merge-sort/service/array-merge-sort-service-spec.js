'use strict';

const should = require('chai').should();

const ArrayMergeSortService = require('../../../src/merge-sort/service/array-merge-sort-service');

describe('Sorting an array of integers.', function () {
    it('should return an int array sorted asc when sort is called, given a randomly sorted int array', () => {
        const arraySorter = new ArrayMergeSortService();
        const unsortedArray = [10, 3, 5, 0, -5, 20, 15, -10, 22, -2, 11];

        arraySorter.sort(unsortedArray).should.deep.equal([-10, -5, -2, 0, 3, 5, 10, 11, 15, 20, 22]);
    })
});
