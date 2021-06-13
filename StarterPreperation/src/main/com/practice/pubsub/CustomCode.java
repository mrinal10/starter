package com.practice.pubsub;

import java.util.ArrayList;
import java.util.List;

class PublisherClass extends Thread {
	private List<Integer> toBePublished;
	private int threshold;

	PublisherClass(List<Integer> pList, int lim) {
		threshold = lim;
		toBePublished = pList;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (toBePublished.size() >= threshold) {
				System.out.println(this.getName() + " OverFlow :: waiting on it");
			}
			int v = (int) (Math.random() * 100);
			toBePublished.add(v);
			System.out.println(this.getName() + " Published :: " + v);
		}
	}

}

class SubscriberClass extends Thread {
	private List<Integer> toBePublished;
	private int threshold;

	SubscriberClass(List<Integer> pList, int lim) {
		threshold = lim;
		toBePublished = pList;
	}

	public void run() {

		while (true) {

			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (toBePublished) {
				if (toBePublished.size() == 0) {
					System.out.println(this.getName() + " UnderFlow :: waiting on it");
					try {
						Thread.sleep(3000);
					} catch (Exception e) {

					}
				}
				System.out.println(this.getName() + " Consumed :: " + toBePublished.remove(0));
			}
		}
	}

}

public class CustomCode {
	public static void main(String[] args) throws InterruptedException {
		List<Integer> ll = new ArrayList<Integer>();

		for (int i = 0; i < 3; i++) {
			PublisherClass p1 = new PublisherClass(ll, 100);
			p1.setName("Producer-"+i);
			p1.start();
		}

		for (int i = 0; i < 5; i++) {
			SubscriberClass s1 = new SubscriberClass(ll, 100);
			s1.setName("Consumer-"+i);
			s1.start();
		}
	}
}
