public class Main {

    public static void main(String[] args) {

        SharedCounter c = new SharedCounter();

        Thread t1 = new Thread(new Worker(c));
        Thread t2 = new Thread(new Worker(c));
        t1.start();
        t2.start();
    }
}