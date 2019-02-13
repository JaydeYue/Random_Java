const expect = require('chai').expect;

const { getMedianPrimes } = require('../routes/randomFunctionalities');

let req = {
    params: {},
};

let res = {
    sendResult: '',
    send: function(arg) {
        this.sendResult = arg.result;
    }
};

describe('randomFunctionalities Tests', function() {
    describe('getMedianPrimes() function', function() {
        it('No n_value provided should give errors', function() {
            getMedianPrimes(req, res);
            expect(res.sendResult).to.equal('Error: Not a number');
        });

        it('None numbers should give erros', function() {
            let newReq = req;
            newReq.params.n_value = 'a';

            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('Error: Not a number');
        });

        it('Negative number should give errors', function() {
            let newReq = req;
            newReq.params.n_value = "-10";

            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('Error: Must be positive');
        });

        it('Should return correct values (single value case)', function() {
            let newReq = req;

            newReq.params.n_value = "18";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[7]');

            newReq.params.n_value = "73";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[31]');
        });

        it('Should return correct values (double value case)', function() {
            let newReq = req;

            newReq.params.n_value = "10";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[3,5]');

            newReq.params.n_value = "71";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[29,31]');
        });

        it('Should return correct values (large value case)', function() {
            let newReq = req;

            newReq.params.n_value = "32452843";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[15485863,15485867]');

            newReq.params.n_value = "224729";
            getMedianPrimes(newReq, res);
            expect(res.sendResult).to.equal('[104729]');
        });
    })
});
