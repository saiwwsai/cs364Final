import java.util.ArrayList;

public class Worker implements Runnable {

    private String id;
    private ArrayList<Integer> l;
    private int start, end;

    public long getSum() {
        return sum;
    }

    private long sum = 0;

    public Worker(String id,
                  ArrayList<Integer> l,
                  int start, int end) {

        this.id = id;
        this.l = l;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        // run is called by the JVM, never
        // directly by you the programmer
        long sum = 0;
        for (int i = this.start; i < this.end; i++)
            sum += this.l.get(i);

        this.sum = sum;
    }
}