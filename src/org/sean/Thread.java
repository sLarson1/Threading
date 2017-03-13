package org.sean;

import java.lang.*;
import java.lang.Runnable;

/**
 * Created by Mr. Sean on 3/12/2017.
 */
public class Thread extends java.lang.Thread {

    String message;
    long duration;
    long startTime;
    long endTime;
    //    int countSeconds;
    long countSeconds;

    public Thread(Runnable target) {
        super(target);
    }

    public void run() {
        super.run();
    }

    public void interrupt() {
        super.interrupt();
    }



}
