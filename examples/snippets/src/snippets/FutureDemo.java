package snippets;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FutureDemo {
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

	public static void main(String args[]) throws InterruptedException, ExecutionException {

		FactorialCalculator task3 = new FactorialCalculator(25);
		FactorialCalculator task1 = new FactorialCalculator(10);
		FactorialCalculator task2 = new FactorialCalculator(20);
		System.out.println("Submitting Task ...");
		Future future1 = threadpool.submit(task1);
		Future future2 = threadpool.submit(task2);
		Future future3 = threadpool.submit(task3);
		Future future4 = threadpool.submit(task1);

		System.out.println("Task is submitted");
		System.out.println("task1 is done:"+future1.get());
		System.out.println("task2 is done:"+future2.get());
		System.out.println("task3 is done:"+future3.get());
		System.out.println("task4 is done:"+future4.get());
		
//		 while (!future1.isDone() || !future2.isDone() || !future3.isDone() ||
//		 !future4.isDone()) {
//		 System.out.println("Task is not completed yet....");
//		 Thread.sleep(1);
//		 // sleep for 1 millisecond before checking again }
//		 System.out.println("Task is completed, let's check result");
//		 long factorial = (long)future1.get();
//		 System.out.println("Factorial of 1000000 is : " + factorial);
//		 threadpool.shutdown();
//		 }
		threadpool.shutdown();
	}

	private static class FactorialCalculator implements Callable<Long> {
		private final int number;

		public FactorialCalculator(int number) {
			this.number = number;
		}

		@Override
		public Long call() {
			long output = 0;
			try {
				output = factorial(number);
			} catch (InterruptedException ex) {
				Logger.getLogger(FactorialCalculator.class.getName()).log(Level.SEVERE, null, ex);
			}
			return output;
		}

		private long factorial(int number) throws InterruptedException {
			if (number < 0) {
				throw new IllegalArgumentException("Number must be greater than zero");
			}
			long result = 1;
			int d = number;
			while (number > 0) {
				Thread.sleep(10);
				// adding delay for example
				result = result * number;
				number--;

			}
			return result;
		}
	}
}
