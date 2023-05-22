public class Main {
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.applyAndPrint(1, x -> x + x);
    }
}