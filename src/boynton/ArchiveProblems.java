package boynton;

/**
 * Series of methods to solve Project Euler archive problems.
 * Not properly commented at all
 */
public class ArchiveProblems {
    public static void main(String args[]) {

        System.out.println(largestProductInAGrid("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08" +
                "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00" +
                "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65" +
                "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91" +
                "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80" +
                "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50" +
                "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70" +
                "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21" +
                "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72" +
                "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95" +
                "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92" +
                "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57" +
                "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58" +
                "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40" +
                "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66" +
                "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69" +
                "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36" +
                "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16" +
                "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54" +
                "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48", 20));

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

    //dont work
    public static double largestProductInAGrid(String n, int gridSize) {
        double check;
        double max = 0;
        int r = 10; //radix
        int size = gridSize;
        int valid;
        //make enum for every direction
        int[] dir = {-21, -20, -19, 1, 21, 20, 19, -1 };

        for(int i = 0; i < n.length(); ++i) {
            for (int aDir : dir) {
                check = 1;
                valid = i + aDir * 4;
                if (valid > 0 && valid < n.length()) {
                    for (int f = 0; f < 4; ++f) {
                        check *= Character.digit(n.charAt(i + aDir * f), r);
                    }
                    if (check > max) {
                        max = check;
                    }
                }
            }
        }
        return max;
    }
}