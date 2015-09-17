package com.home.education.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;


public class Main {
	
	public static void main(String[] args) {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("ping-pong-thread-%d").build();
		Random random = new Random();
		int numberOfThreads = random.nextInt(30);
		System.out.println(numberOfThreads);
		Printer printer = new Printer("Ping");
		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads, threadFactory);
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		Lock lock = readWriteLock.writeLock(); 
		for (int i = 0; i < numberOfThreads; ++i) {
			executorService.execute(new PingPong(printer, lock));
		}
		executorService.shutdown();
	}
}
