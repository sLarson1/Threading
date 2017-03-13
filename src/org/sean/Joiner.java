package org.sean;

/**
 * Created by Mr. Sean on 3/12/2017.
 */
public class Joiner extends Runnable {

    java.lang.Runnable joinThread;

    public Joiner(long duration){
        super(duration);
    }

    public Joiner(long duration, java.lang.Runnable join){
        super(duration);
        this.joinThread = join;
    }

    public void run(){
        super.run();
    }
}
