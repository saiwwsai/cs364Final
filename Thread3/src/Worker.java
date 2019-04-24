public class Worker implements Runnable {

    SharedCounter c;

    public Worker(SharedCounter c) {
        this.c = c;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {


            // do a little work -computation
            double sum = 0;
            for (int j = 0; j < 1000; j++)
                sum += Math.random() * 100;

                long x = c.inc();
                System.out.println(Long.toString(x) +
                        "  " + sum);
        }

    }
}