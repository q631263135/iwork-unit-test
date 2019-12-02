package com.example.main.jgbs;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/13 18:44
 */
public class ManagerJob implements Runnable {

    private static CyclicBarrier cyclicBarrier;

    private ManagerJob() {

    }

    public static void main(String[] args) {

        ExecutorService service =
                Executors.newCachedThreadPool();

        service.execute(new ManagerJob());

        service.execute(new Job1(cyclicBarrier));
        service.execute(new Job2(cyclicBarrier));
    }

    @Override
    public void run() {

        cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });
    }
}
