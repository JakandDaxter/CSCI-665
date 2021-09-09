import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @file Primes.java
 *
 * @brief A single nonnegative integer, n, not larger than 10,000. Output:
 * A list of all of the prime numbers less than or equal to n, in increasing order, each on its own line.
 *
 * @Class CSCI-665  Section 1
 * @Professor Ting Cao
 * @Date 08/29/2021
 * @author Aliana Tejeda
 * Contact: axt3290@rit.edu
 *
 */

/**
Code taken from my repo
 https://github.com/JakandDaxter/CSCI-605/blob/Homework1/src/primality/SieveOfEratosthenes.java
 */

public class Primes {
        //method to find prime numbers
        public static int[] makeSieve(int upperBound) {
            /* Creating array with upper bound, plus 1 to create all buckets user intended*/
            int[] sieve = new int[upperBound + 1];

            //array is set to all prime
            Arrays.fill(sieve, 0);
		/*
		check buckets up until the square root of the upper bound
		since sqrd(sqrt(upperbound)) is <=upperbound, any number
		after that will exceede the limit since the square root
		of the upper bound is the cloest you can get to the
		perfect square of the upper bound
		 */
            for (int i = 2; i <= Math.sqrt(upperBound); i++) {
			/*
			starting at i, for i+i is not prime, then
			j = i+i, where j is then j = j+i for every
			multiple of i, which is not prime
			 */
                for (int j = i + i; j <= upperBound; j = i + j) {
                    sieve[j] = 1;
                }
            }

            return sieve;
        }

        public static void main(String[] args) {

            try {
                //Single Nonnegative integer n
                int n = Integer.parseInt(args[0]);

                if(n<=0) {
                    throw new Exception("Value Cannot Be 0 or Negative");
                }
                int[] sieve = makeSieve(n);

                for (int i = 2; i <= sieve.length - 1; i++) {
                    if (sieve[i] == 0) {
                        System.out.println(i);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}









