//The prime factors of 13195 are 5, 7, 13 and 29.
//
//What is the largest prime factor of the number 600851475143 ?

public class LargestPrimeFactor {

    private static long num = 600851475143L;


    public static void main(String[] args){


        while(num != primeDivide()){
            primeDivide();
        }

        System.out.println(num);

    }

    /**
     * will divide the number by the smallest possible factor
     * this continues until the last prime factor which is the largest prime factor
     * @return the prime factor
     */

    private static long primeDivide(){

        //for multiples 2
        if (num % 2 == 0) {
            num = num / 2;
            return 2;
        }

        // for multiples of 3
        if (num % 3 == 0) {
            num = num / 3;
            return 3;
        }

        //for multiples of all other prime numbers
        long i = 5;
        while(Math.pow(i,2) <= num){
            if (num % i == 0){
                num = num / i;
                return i;
            }

            if(num % (i + 2) == 0){
                num = num / (i + 2);
                return i + 2;
            }

            i += 6;
        }

        //last prime which will be the largest prime factor
        return num;
    }
}
