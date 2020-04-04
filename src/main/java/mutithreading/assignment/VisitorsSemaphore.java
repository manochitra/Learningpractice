package mutithreading.assignment;

import java.util.concurrent.Semaphore;

public class VisitorsSemaphore {


    static Semaphore semaphore = new Semaphore(5);

    static class VisitorThread extends Thread {

        String name = "";

        VisitorThread(String name) {
            this.name = name;
        }

        public void run() {

            try {


                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 6; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        VisitorThread t1 = new VisitorThread("AVisitor");
        t1.start();

        VisitorThread t2 = new VisitorThread("BVisitor");
        t2.start();

        VisitorThread t3 = new VisitorThread("CVisitor");
        t3.start();

        VisitorThread t4 = new VisitorThread("DVisitor");
        t4.start();

        VisitorThread t5 = new VisitorThread("EVisitor");
        t5.start();

        VisitorThread t6 = new VisitorThread("FVisitor");
        t6.start();

    }
}

