/**
 * Run this program twice:
 *
 * 1. remove synchronized from the method -- public void run()
 *
 * 2. add synchronized -- public synchronized void run()
 */

public class SynThread implements Runnable {

    private String holdA = "This is ";
    private int[] holdB = {1,2,3,4,5,6,7,8,9,10};

    //synchronized
    public synchronized void  run() {
        for(int w = 0; w < 10; w++) {
            System.out.println(holdA + holdB[w] + ". " +Thread.currentThread().getName());
        }
    }

    public static void main(String args[]) {
        SynThread z = new SynThread();
        new Thread(z).start();
        new Thread(z).start();
    }
}

