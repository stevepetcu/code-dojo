'use strict';

const {should, assert} = require('./../../bootstrap');
const HeapNode = require('./../../../src/heap-sort/model/heap-node');

describe('A heap node\'s basic functionality', () => {
    let heapNode;

    beforeEach(() => {
        heapNode = new HeapNode(10);
    });

    it('Should be constructed with an immutable and retrievable value', () => {
        heapNode.getValue().should.be.equal(10);
    });

    it('Should undefined indexes originally', () => {
        assert.isUndefined(heapNode.getIndex(), 'The index should be initially undefined.');
        assert.isUndefined(heapNode.getParentIndex(), 'The parent index should be initially undefined.');
        assert.isUndefined(heapNode.getLeftChildIndex(), 'The left child index should be initially undefined.');
        assert.isUndefined(heapNode.getRightChildIndex(), 'The right child index should be initially undefined.');
        assert.isUndefined(heapNode.getParentIndex(), 'The parent index should be initially undefined.');
    });

    it('Should be able to set and get its indexes', () => {
        heapNode
            .setIndex(1)
            .setParentIndex(2)
            .setLeftChildIndex(3)
            .setRightChildIndex(4);

        heapNode.getIndex().should.be.equal(1);
        heapNode.getParentIndex().should.be.equal(2);
        heapNode.getLeftChildIndex().should.be.equal(3);
        heapNode.getRightChildIndex().should.be.equal(4);
    });
});
