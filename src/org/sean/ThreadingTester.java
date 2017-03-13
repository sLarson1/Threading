package org.sean;

/**
 * Created by slarson on 3/10/2017.
 */
public class ThreadingTester {



    public static void main(String[] args){
        Object lock = new Object();
        Runnable run1 = new Runnable(2000, "run1", null, null, true);
        Thread thread1 = new Thread(run1);
        thread1.setName("thread1");

        Runnable run2 = new Runnable(2000, "run2", thread1, null, true);
        Thread thread2 = new Thread(run2);
        thread2.setName("thread2");

        Runnable run3 = new Runnable(2000, "run3", thread2, null, true);
        Thread thread3 = new Thread(run3);
        thread3.setName("thread3");

        Runnable run4 = new Runnable(2000, "run4", thread3, null, true);
        Thread thread4 = new Thread(run4);
        thread4.setName("thread4");

        thread4.start();
        thread3.start();
        thread2.start();
        thread1.start();


        System.out.println("\n\n\n------------------------- SECOND SET!!!!!!!!      -------------");


        run1 = new Runnable(2000, "run1.1", null, null, false);
        thread1 = new Thread(run1);
        thread1.setName("thread1");

        run2 = new Runnable(2000, "run2.1", thread1, null, false);
        thread2 = new Thread(run2);
        thread2.setName("thread2");

        run3 = new Runnable(2000, "run3.1", thread2, null, false);
        thread3 = new Thread(run3);
        thread3.setName("thread3");

        run4 = new Runnable(2000, "run4.1", thread3, null, false);
        thread4 = new Thread(run4);
        thread4.setName("thread4");

        thread4.start();
        thread3.start();
        thread2.start();
        thread1.start();

        System.out.println("main program exiting.  Thread is:"+Thread.currentThread().getName());
/*        Runnable runnable1 = new Runnable(1000l);
        runnable1.message="thread1";
        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = new Runnable(1000l);
        runnable2.message="thread2";
        Thread thread2 = new Thread(runnable2);

        Runnable runnable3 = new Runnable(1000l);
        runnable3.message="thread3";
        Thread thread3 = new Thread(runnable3);

        try {
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        }catch(Throwable t){
            System.err.println(t);
        }
        System.out.println("done");*/
    }

}
