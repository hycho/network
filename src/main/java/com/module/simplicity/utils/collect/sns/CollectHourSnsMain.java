package com.module.simplicity.utils.collect.sns;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * SNS을 시간대별로 수집하는 로직
 */
public class CollectHourSnsMain {
	
	private final static int maxTreads = 100;
	
    public static void main( String[] args ) throws InterruptedException, ExecutionException {
        System.out.println( "Start CollectHourSnsMain." );
   
        List<CollectFBSns> collectFbSns = new ArrayList<CollectFBSns>();
        
        int i = 0;
        while(i < 1000) {
        	collectFbSns.add(new CollectFBSns("https://api.facebook.com/method/links.getStats?urls=http://naver.com&format=json"));
        	i++;
        }
        
        long start = System.currentTimeMillis();

        ExecutorService es = Executors.newFixedThreadPool(maxTreads);
        List<Future<Integer>> result = es.invokeAll(collectFbSns);
        es.shutdown();

        long end = System.currentTimeMillis();
        System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
        
        System.out.println( "End CollectHourSnsMain." );
    }
}
