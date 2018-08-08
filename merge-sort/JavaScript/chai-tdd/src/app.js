'use strict';

const server = require('express')();
const express = require('express');
const router = express.Router();

const requestBodyParser = require('body-parser');

const ArrayMergeSorterService = require('./merge-sort/service/array-merge-sort-service');
const ArrayMergeSortController = require('./merge-sort/controller/array-merge-sort-controller');

server.set('port', process.env.PORT || 8081);

server.use(requestBodyParser.json());
server.use(function (err, req, res, next) {
    console.error(err.stack);
    res.status(500).send('Internal server error');
});

const arraySorter = new ArrayMergeSorterService();
const arraySorterController = new ArrayMergeSortController(router, arraySorter);

server.use('/sort', arraySorterController.sort());

const start = () => {
    server.listen(server.get('port'), function() {
        console.log(`Server started on port ${server.get('port')} of your domain; press Ctrl-C to terminate.`)
    })
};

start();
