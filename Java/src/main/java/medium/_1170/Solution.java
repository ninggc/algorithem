package medium._1170;

import java.util.concurrent.Semaphore;

class H2O {

    Semaphore hSemaphore = new Semaphore(2);
    Semaphore oSemaphore = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hSemaphore.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oSemaphore.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oSemaphore.acquire(2);

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hSemaphore.release(2);
    }
}