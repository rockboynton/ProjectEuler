package boynton;

public class Problem14 {

    public static long getAnswer() {
        final int MILLION = 1000000;

        long currentCount;
        long bestCount = 0;
        long currentNum;
        long currentNumCopy;
        long bestNum = 13;

        for (long i = 13; i < MILLION ; i++) {
            currentNum = i;
            currentNumCopy = i;
            currentCount = 0;
            while (currentNumCopy != 1) {
                currentCount++;
                currentNumCopy = getNextNum(currentNumCopy);
            }
            if (currentCount > bestCount) {
                bestCount = currentCount;
                bestNum = currentNum;
            }
        }
        return bestNum;
    }

    public static long getNextNum(long num) {
        if (num%2 == 0 ) {
            return num / 2;
        } else {
            return num * 3 + 1;
        }
    }
}
