
import java.io.*;
import java.util.*;

public class Primes {
    public static void main(String[] args) {
        // isPrime tests
        assert(!isPrime(1));
        assert( isPrime(2));
        assert( isPrime(3));
        assert(!isPrime(4));
        assert(isPrime(103));
        assert(!isPrime(111));
        
        // getSieve tests
        assert(countPrimes(getSieve(      10)) ==      4);
        assert(countPrimes(getSieve(     100)) ==     25);
        assert(countPrimes(getSieve(    1000)) ==    168);
        assert(countPrimes(getSieve(   10000)) ==   1229);
        assert(countPrimes(getSieve(  100000)) ==   9592);
        assert(countPrimes(getSieve( 1000000)) ==  78498);
        assert(countPrimes(getSieve(10000000)) == 664579);

        System.out.println("Done.");
    }

    // Helper method to count primes in sieve
    public static int countPrimes(boolean[] sieve) {
        int count = 0;

        for(int i=0; i<sieve.length; i++)
            if(sieve[i])
               count++;

        return count;
    }

    /*
     *   DESCRIPTION: Determines whether a number is prime
     * OPTIMIZATIONS: Only checks up to sqrt(x), guards against x < 2
     *
     *  INPUT: integer x
     * OUTPUT: true if prime, false otherwise
     * 
     *   TIME: O(sqrt(x)) = O(2^(N/2)) -- where N is bit operations
     *  SPACE: O(1)
     *
     */
    public static boolean isPrime(int x) {
        if(x<2) return false;

        int root = (int)Math.sqrt(x);
        for(int i=2; i<=root; ++i)
            if(x % i == 0)
                return false;
        return true;
    }

    /*
     *   DESCRIPTION: Finds all primes up to n
     * OPTIMIZATIONS: Start sieve at 2, only check up to sqrt(x), increments starting at x^2 
     *
     *  INPUT: integer n
     * OUTPUT: boolean[] marked as true if prime, false otherwise
     * 
     *   TIME: O(Nloglog(N)) -- prime harmonic series asymptotically approaching loglog(n)
     *  SPACE: O(N)
     *
     */
    public static boolean[] getSieve(int n) {
        assert(n > 0);

        int limit = (int)Math.sqrt(n);

        boolean[] sieve = new boolean[n];
        Arrays.fill(sieve, true);
        sieve[0] = false;

        // Since 1 is not prime, start with 2
        for(int i=2; i<=limit; i++)
            if(sieve[i-1])
                for(int j=i*i; j<=n; j+=i)
                    sieve[j-1] = false;

        return sieve;
    }
}
