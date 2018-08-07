'use strict';

const chai = require('chai');
const expect = chai.expect;

const express = require('express');
const router = express.Router();

const requestBodyParser = require('body-parser');

const ArrayMergeSorterService = require('../src/merge-sort/service/array-merge-sort-service');
const ArrayMergeSortController = require('../src/merge-sort/controller/array-merge-sort-controller');

chai.use(require('chai-http'));

describe('Sorting an array over HTTP', () => {
    let server;

    before((next) => {
        const arraySorter = new ArrayMergeSorterService();
        const arraySorterController = new ArrayMergeSortController(router, arraySorter);

        server = express()
            .use(requestBodyParser.json())
            .use('/sort', arraySorterController.sort())
            .listen(() => {
                return next();
            });
    });

    after(() => {
        server.close();
    });

    it(
        'should return an HTTP response containing an int array sorted asc,' +
        ' given an HTTP request containing a randomly sorted integer array', () => {
            const port = server.address().port;
            const agent = chai.request(`http://localhost:${port}`);

            const requestBody = [10, 3, 5, 0, -5, 20, 15, -10, 22, -2, 11];

            return agent
                .post('/sort')
                .send(requestBody)
                .then((res) => {
                    expect(res.status).to.equal(200);
                    expect(res.body).to.deep.equal([-10, -5, -2, 0, 3, 5, 10, 11, 15, 20, 22]);
                });
        });
});
