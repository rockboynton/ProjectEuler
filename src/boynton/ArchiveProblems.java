package boynton;

/**
 * Series of methods to solve Project Euler archive problems.
 * Not properly commented at all
 */
public class ArchiveProblems {
    public static void main(String args[]) {

        System.out.println(summationOfPrimes());
        System.out.println(isPrime(1));

    }

    /**
     * @return largest prime factor of a number
     */
    public static int largestPrimeFactor(long number) {
        int i;
        long copyOfInput = number;

        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                copyOfInput /= i;
                i--;
            }
        }

        return i;
    }

    /**
     * Finds the largest palindrome made from the product of two 3-digit numbers.
     * @return result
     */
    public static int largestPalindrom() {
        int max = 100001;

        for ( int i = 999 ; i >= 100 ; i--) {
            for (int j = 999 ; j >= 100 ; j-- ) {
                int p = i * j;
                if ( max < p && isPalindrome(p) ) {
                    max = p;
                }
            }
        }

        return max;
    }

    /**
     * Determines whether a number is palindrome
     * @param num number to check
     */
    public static boolean isPalindrome(int num) {
        StringBuilder fwd = new StringBuilder(Integer.toString(num));
        StringBuilder bwd = new StringBuilder(Integer.toString(num));
        bwd.reverse();
        String fwdStr = fwd.toString();
        String bwdStr = bwd.toString();

        return fwdStr.equals(bwdStr);

    }

    public static int smallestEvenlyDivisible() {
        boolean found = false;
        boolean stop;
        int res = 0;
        for (int i = 20; !found; i+=2) {
            stop = false;
            for (int k = 3; k < 21 && !stop; ++k) {
                if ((i % k) != 0) {
                    stop = true;
                }
                if (k == 20) {
                    res = i;
                    found = true;
                }
            }
        }
        return res;
    }

    public static int sumSquareDifference() {
        int sumSquare = 0;
        int squareSum = 0;

        for (int i = 1; i <= 100; ++i) {
            squareSum += Math.pow(i, 2);
            sumSquare += i;
        }
        sumSquare = (int) Math.pow(sumSquare, 2);
        return sumSquare - squareSum;

    }

    //104743
    public static int prime100001st() {
//        ArrayList<Integer> primes = new ArrayList<>();
        int count = 0;
        int i;
        for (i = 1; count < 10001; ++i) {
            if (isPrime(i)) {
                count++;
            }
        }
        return i-1;
    }

    public static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        // fast even test.
        if(n != 2 && n%2 == 0) {
            return false;
        }
        // only odd factors need to be tested up to n^0.5
        for(int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }


    /**
     * works
     * @param s
     * @return
     */
    public static long largestProductInSeries(String s) {
        long max = 0L;
        long prod;

        for (int i = 0; i < s.length() - 13; i++) {
            prod = 1L;
            for (int k = i; k < i+13; k++) {
                prod *= Character.digit(s.charAt(k), 10);
            }
            if (prod > max) {
                max = prod;
            }
        }
        return max;

    }

    public static double specialPythagoreanTriplet() {
        double c = 0;
        int a = 0;
        int b = 0;
        boolean flag = false;

        for (a = 0; a < 500 && !flag; ++a) {//Math.pow(a, 2) + Math.pow(b, 2)
            c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            if (a + b + c == 1000) {
                flag = true;
                a--;
            }
            for (b = 0; b < 500 && !flag ; ++b) {
                c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if (a + b + c == 1000) {
                    flag = true;
                    a--;
                    b--;
                }
            }
        }

        return a*b*c;
    }

    public static long summationOfPrimes() {
        long sum = 0;
        for (int i = 0; i < 2e6; ++i) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static double largestProductInAGrid(String n, int gridSize) {
        double check;
        double max = 0;
        int r = 10; //radix
        int size = gridSize;

        //make enum for every direction
        int[] dir = {-21, -20, -19, 1, 21, 20, 19, -1 };

        int topLeftDiag;
        int up;
        int topRightDiag;
        int right;
        int bottomRightDiag;
        int down;
        int bottomLeftDiag;
        int left;

        for(int i = 0; i < n.length(); ++i) {
            check = 1;
            topLeftDiag = i - (gridSize+1)*3;
            //loop over array, check so no iob errorsk
            if (topLeftDiag > 0) {
                for (int f = 0; f < 4; ++f) {
                    check *= Character.digit(n.charAt(i - (gridSize+1)*f), r);
                }
                if (check > max) {
                    check = max;
                }
            }

        }
        return max;
    }
}

