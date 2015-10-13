package com.module.simplicity.network.thread.fce;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedMaxFinder {
	public static void main(String[] args) {
		int[] data = new int[5];
		data[0] = 111;
		data[1] = 711;
		data[2] = 7311;
		data[3] = 411;
		data[4] = 3711;
		
		try{
			System.out.println(max(data));
		} catch(InterruptedException| ExecutionException ex) {
			System.err.println(ex);
		}
	}
	
	public static int max(int[] data) throws InterruptedException, ExecutionException {
		if(data.length == 1) {
			return data[0];
		} else if(data.length == 0) {
			throw new IllegalArgumentException();
		}
		
		FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
		FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future<Integer> f1 = es.submit(task1);
		Future<Integer> f2 = es.submit(task2);
		
		return Math.max(f1.get(), f2.get());
	}
}
