'use strict';

class HeapNode {
    constructor(value) {
        const _value = parseInt(value);
        let _index, _parentIndex, _leftChildIndex, _rightChildIndex;

        this.getValue = () => {
            return _value;
        };

        this.getIndex = () => {
            return _index;
        };

        this.getParentIndex = () => {
            return _parentIndex;
        };

        this.getLeftChildIndex = () => {
            return _leftChildIndex;
        };

        this.getRightChildIndex = () => {
            return _rightChildIndex;
        };

        this.setIndex = (index) => {
            _index = index;

            return this;
        };

        this.setParentIndex = (index) => {
            _parentIndex = index;

            return this;
        };

        this.setLeftChildIndex = (index) => {
            _leftChildIndex = index;

            return this;
        };

        this.setRightChildIndex = (index) => {
            _rightChildIndex = index;

            return this;
        };
    }
}

module.exports = HeapNode;
