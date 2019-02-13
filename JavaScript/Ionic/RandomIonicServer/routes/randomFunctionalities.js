module.exports = {
    /*The function for finding median of prime numbers less than n*/
    getMedianPrimes: function(req, res) {
        let n_value = Number(req.params.n_value);

        // Deal with invalid inputs
        if (isNaN(n_value)) {
            return res.send({"result": 'Error: Not a number'});
        } else if (n_value < 0) {
            return res.send({"result": 'Error: Must be positive'});
        }

        let primes = findAllPrimes(n_value);
        if (primes.length == 0) {
            return res.send({"result": '[]'});
        } else if (primes.length%2 != 0) {
            return res.send({"result": '[' + primes[Math.floor(primes.length/2)] + ']'});
        } else {
            return res.send({"result": '[' + primes[primes.length/2 - 1] + ',' + primes[primes.length/2] + ']'});
        }
    }
}

/*Find all primes up to and including max*/
const findAllPrimes = max => {
    // Make array of length floor of max +1 (since there is a 0 index)
    // and fill the array with true
    // Each index corresponds to the number of the index
    let limitInteger = Math.floor(max) + 1;
    let allNums = new Array(limitInteger).fill(true);
    let primes = [];

    // If the number is labelled a prime then we can start at i^2 and mark
    // every multiple of i from there as not a prime;
    // And we add the current i to our prime list
    for (let i = 2; i < Math.sqrt(limitInteger); i++) {
        if (allNums[i]) {
            primes.push(i);
            for (let j = Math.pow(i, 2); j < limitInteger; j += i) {
                allNums[j] = false
            }
        }
    }

    // Add remaining indexes with true values to our prime list
    for (i = Math.floor(Math.sqrt(limitInteger)) + 1; i < limitInteger; i++) {
        if (allNums[i]) {
            primes.push(i);
        }
    }

    return primes;
}
