package com.home.education.concurrent;

import java.util.concurrent.locks.Lock;

public class PingPong implements Runnable {

	private final Printer printer;
	private final Lock lock;

	public PingPong(Printer printer, Lock lock) {
		this.printer = printer;
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		if (printer.getMessage().contains("Ping")) {
			printer.setMessage("Pong");
		} else {
			printer.setMessage("Ping");
		}
		printer.print();
		lock.unlock();
	}
}
