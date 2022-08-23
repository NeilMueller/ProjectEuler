import java.util.ArrayList;
import java.util.List;

public class SmallestMultiple {

    private static final int NUM = 20;
    private static int numberOfPrimes;
    private static int[] indivPrimeFactors;
    private static int[] totalPrimeFactors;

    public static void main(String[] args){

        //gets the number of primes that will be the factors
        numberOfPrimes = numberOfPrimes(NUM);
        totalPrimeFactors = new int[numberOfPrimes];

        //get the prime factors of every number up to our NUM
        //our answer will need to contain all of these
        //so we will take the prime factors of all the numbers from 1 - NUM
        for(int i = 2; i <= NUM; i++){
            getPrimeFactors(i);

            //update the prime factors required for including all numbers up to i
            for(int j = 0; j < numberOfPrimes; j++){
                totalPrimeFactors[j] = Math.max(indivPrimeFactors[j], totalPrimeFactors[j]);
            }
        }

        //Calculate product of prime factors
        System.out.print(calculateProduct());
    }

    /**
     * fills list
     * @param n upper bound of the primes you want to reach
     * @return number of primes smaller than inclusive upper bound
     */
    public static int numberOfPrimes(int n){
        int count = 0;

        if(n > 2){
            count++;
        }
        if(n > 3){
            count++;
        }

        int i = 5;
        while(i <= n){
            count++;
            if(i+2 <= n){
                count++;
            }
            i += 6;
        }

        return count;
    }

    /**
     * places the power of the prime factors in indiv prime factor for number n
     * @param n
     */
    public static void getPrimeFactors(int n){
        indivPrimeFactors = new int[numberOfPrimes];
        boolean done = false;
        int index;
        while(n != 1) {
            index = 0;
            //for multiples 2
            if (n % 2 == 0) {
                n = n / 2;
                indivPrimeFactors[index]++;
                continue;
            }

            // for multiples of 3
            index++;
            if (n % 3 == 0) {
                n = n / 3;
                indivPrimeFactors[index]++;
                continue;
            }

            //for multiples of all other prime numbers
            int i = 5;
            while (i <= n) {
                index++;
                if (n % i == 0) {
                    n = n / i;
                    indivPrimeFactors[index]++;
                    continue;
                }

                index++;
                if (n % (i + 2) == 0) {
                    n = n / (i + 2);
                    indivPrimeFactors[index]++;
                    continue;
                }

                i += 6;
            }

        }
    }

    /**
     * takes the prime factors of our answer and multiplies them
     * @return the product of all the prime factors
     */
    public static int calculateProduct(){
        int index = 0;
        int product = 1;

        //for multiples 2
        product *= Math.pow(2,totalPrimeFactors[index]);

        // for multiples of 3
        index++;
        product *= Math.pow(3,totalPrimeFactors[index]);

        //for multiples of all other prime numbers
        int i = 5;
        while (index < numberOfPrimes) {
            index++;
            if(index < numberOfPrimes) {
                product *= Math.pow(i,totalPrimeFactors[index]);
            }

            index++;
            if(index < numberOfPrimes) {
                product *= Math.pow(i + 2,totalPrimeFactors[index]);
            }

            i += 6;
        }

        return product;
    }
}
