package boynton;

public class EulerDriver {

    public static void main(String[] args) {

        long startTime = System.nanoTime();


        System.out.println(Problem14.getAnswer());


        long endTime = System.nanoTime();

        System.out.println("That took " + (endTime - startTime)/1e6 + " milliseconds");
    }
}
