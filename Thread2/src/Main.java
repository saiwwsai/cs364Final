import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> l = new ArrayList<>();

        // create a million random integers
        // for testing
        for (int i = 0; i < 1e6; i++) {
            l.add((int) (Math.random() * 1000));
        }

        Worker w1 = new Worker("Ping", l,
                        0, l.size()/2);

        Thread t1 = new Thread(w1);

        Worker w2 = new Worker("Pong", l,
                        l.size()/2,l.size());

        Thread t2 = new Thread(w2);

        // order does not matter
        System.out.println("Main");
        t1.start();
        t2.start(); // asynchronous call

        try {
            t1.join();  // wait for t1 to finish
            t2.join();  // wait for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        long sum = w1.getSum() + w2.getSum();
        System.out.println("Total sum is:" + sum);
    }
}