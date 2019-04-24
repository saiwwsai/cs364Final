public class Speak implements Runnable {

    String s;
    volatile Turn t;
    private boolean myTurn;

    public Speak(String s, Turn t, boolean myTurn) {
        this.s = s;
        this.t = t;
        this.myTurn = myTurn;
    }

    /*
       The run function that uses a busy-wait loop

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            while (this.myTurn != this.t.t);

            System.out.println(this.s);
            this.t.t = !this.t.t;
        }
    }
    */

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {

            // wait until it my turn
            while (this.myTurn != this.t.t) {

                synchronized (this.t) {
                    try {
                        this.t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            // toggle the turn
            System.out.println(this.s);
            this.t.t = !this.t.t;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // notify any thread sleeping on this.t
            // to wake up and recheck its condition
            synchronized (this.t) {
                this.t.notifyAll();
            }
        }
    }
}