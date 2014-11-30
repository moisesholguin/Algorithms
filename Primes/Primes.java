
import java.io.*;
import java.util.*;

public class Primes {
    public static void main(String[] args) {
        // isPrime tests
        assert(!isPrime(1)); assert(isPrime(2));   assert(isPrime(3));
        assert(!isPrime(4)); assert(isPrime(103)); assert(!isPrime(111));
        

        System.out.println("Done.");
    }

    /*
     *   DESCRIPTION: Determines whether a number is prime
     * OPTIMIZATIONS: Only checks up to sqrt(x), guards against x < 2
     *
     *  INPUT: integer x
     * OUTPUT: true if prime, false otherwise
     * 
     *   TIME: O(sqrt(x)) = O(2^(n/2)) -- where n is bit operations
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
}
