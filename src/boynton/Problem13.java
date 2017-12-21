package boynton;

import java.math.BigInteger;

public class Problem13 {

    public final int numLength;
    public String nums;

    public Problem13(int numLength, String nums) {
        this.numLength = numLength;
        this.nums = nums;
    }

    public BigInteger getAnswer() {
        BigInteger ans = new BigInteger("0");
        BigInteger current;
        String sub;
        int count = 0;

        for (int i = 0; i < 5000; i += 50) {
            count++;
            sub = nums.substring(i, i+50);
            current = new BigInteger(sub);
            ans = ans.add(current);
        }
        System.out.println(count);
        String ansStr = ans.toString();
        return ans;//ansStr.substring(0, 10);
    }
}
