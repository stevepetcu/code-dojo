'use strict';

class ArrayMergeSortController {
    constructor(router, arrayMergeSorterService) {
        this.sort = () => {
            router.post('/', (req, res) => {
                res.status(200).send(arrayMergeSorterService.sort(req.body));
            });

            return router;
        };
    }
}

module.exports = ArrayMergeSortController;
