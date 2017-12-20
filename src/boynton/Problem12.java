package boynton;

public class Problem12 {

    public final int divisors;
    private long currentTriNum;
    private int count;

    public Problem12(int divisors) {
        this.divisors = divisors;
        currentTriNum = 1;
    }

    public long getAnswer() {

        while (getCurrentNumDivisors() < divisors) {
            getNextTriNum();
        }

        return getCurrentTriNum();
    }

    public long getCurrentTriNum() {
        return currentTriNum;
    }

    public void setCurrentTriNum(int currentTriNum) {
        this.currentTriNum = currentTriNum;
    }

    public long getNextTriNum() {
        int res = 0;
        count++;
        for (int i = 1; i <= count; i++) {
            res += i;
        }
        setCurrentTriNum(res);
        return res;
    }

    public int getCurrentNumDivisors() {
        int numDivisors = 0;
        long n = getCurrentTriNum();
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                numDivisors++;
            }
        }

        return numDivisors * 2;
    }
}
