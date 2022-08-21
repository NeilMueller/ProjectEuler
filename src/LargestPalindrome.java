public class LargestPalindrome {

    public static void main(String[] args){

        int largestPalindrome = 0;

        for(int a = 999; a >= 100; a--){
            for(int b = a; b >= 100; b--){
                int n = a*b;
                if(n <= largestPalindrome) break;
                if(isPalindrome(n)) largestPalindrome = n;
            }
        }


        System.out.println(largestPalindrome);
    }

    public static int reversed(int n){

        int reversed = 0;

        while(n > 0){
            reversed *= 10;
            reversed += n%10;
            n = Math.floorDiv(n,10);
        }

        return reversed;
    }

    public static boolean isPalindrome(int n){
        if(n == reversed(n)) return true;
        return false;
    }
}
