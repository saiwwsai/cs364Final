public class SharedCounter {

    long i = 0;  // package visible

    // inc is atomic
    synchronized long inc() {
        return ++i;
    }

    long get() { return this.i; }

}