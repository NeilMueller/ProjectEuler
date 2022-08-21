import java.util.List;

public class SmallestMultiple {

    private static final int NUM = 20;
    private static List<Integer> primes;

    public static void main(String[] args){

        //gets the number of primes that will be the factors
        //and fills a list of primes
        int numberOfPrimes = numberOfPrimes(NUM);

    }

    public static int numberOfPrimes(int n){
        int count = 0;

        if(n > 2){
            count++;
            primes.add(2);
        }
        if(n > 3){
            count++;
            primes.add(3);
        }

        int i = 5;
        while(i <= n){
            count++;
            primes.add(i);
            if(i+2 <= n){
                count++;
                primes.add(i+2);
            }
            i += 6;
        }

        return count;
    }

    public static int
}
