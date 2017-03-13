package org.sean;

import java.lang.*;

/**
 * Created by Mr. Sean on 3/12/2017.
 */
public class Runnable implements java.lang.Runnable{

    String name;
    String message;
    long duration;
    long startTime;
    long endTime;
    long countSeconds;
    Thread before;

    public String toString() {
        return "Runnable{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", duration=" + duration +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", countSeconds=" + countSeconds +
                ", before=" + before +
                ", after=" + after +
                ", doJoin=" + doJoin +
                '}';
    }

    Thread after;
    boolean doJoin;


    public Runnable(long duration){
        this.duration = duration;
    }

    public Runnable(long duration, String name, Thread before, Thread after, boolean doJoin){

        this.duration = duration;
        this.name = name;
        this.before = before;
        this.after = after;
        this.doJoin = doJoin;
    }

    public void run() {
        System.out.println("\nEntered "+name +".run() Started by"+Thread.currentThread().getName() +"- " +System.currentTimeMillis());

        startTime = System.currentTimeMillis();
        countSeconds = 0;
        System.out.println("starttime:"+startTime);

        doWork(System.currentTimeMillis());

        doJoin();
        System.out.println("\nDone waiting on:"+(before!=null?before.getName():"nobody") +" now resuming work on:"+this.name);

        doWork(System.currentTimeMillis());

        System.out.println(this+"is done! CountSeconds:"+countSeconds +", difference:"+(endTime-startTime));
    }

    void doJoin(){
        // check for null in case we are the first thread
        while(doJoin && before != null && before.isAlive()){

            try {
                System.out.println(this.name +" about to join on:"+before.getName());
                before.join();
            } catch (InterruptedException e) {
                System.err.println("Got interrupted!- waiting on "+before.getName()+e);
            }

        }

    }

    void doWork(long startTime){
        while((startTime + duration) > System.currentTimeMillis()){
            //  countSeconds is longer than duration since the cpu can execute the while loop more
            // than once per millisecond
            countSeconds++;
        }
        endTime = System.currentTimeMillis();
    }
}
