package boynton;

public class EulerDriver {

    public static void main(String[] args) {
        Problem12 x = new Problem12(500);
        String verify = "" + x.getAnswer();
        System.out.println(verify);
    }
}
