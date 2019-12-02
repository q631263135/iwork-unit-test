package com.example.main.jgbs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/13 18:42
 */
public class Job1 implements Runnable {

    public static CyclicBarrier cyclicBarrier;

    public Job1(CyclicBarrier cb) {
        this.cyclicBarrier = cb;
    }

    @Override
    public void run() {

        try {
            System.out.println("Job1");
            cyclicBarrier.await();
            System.out.println("Job1 end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
