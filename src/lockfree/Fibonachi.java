package lockfree;

import java.math.BigInteger;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:10:59 PM 

public class Fibonachi {
	
	class Pair {
		BigInteger a, b;

		Pair(BigInteger a, BigInteger b) {
			this.a = a;
			this.b = b;
		}

		BigInteger sum() {
			return b.add(a);
		}
	}

	AtomicReference<Pair> state = new AtomicReference<>(new Pair(
			BigInteger.ZERO, BigInteger.ONE));

	public BigInteger next() {
		Pair curr, update;
		BigInteger ans;
		do {
			curr = state.get();
			ans = curr.sum();
			update = new Pair(curr.b, ans);
		} while (!state.compareAndSet(curr, update));
		return ans;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		final int threads = 3;
		final int tasks = 100;
		
		final Fibonachi alg = new Fibonachi();

		ExecutorService executor = Executors.newFixedThreadPool(threads);

		CompletionService<BigInteger> sc = new ExecutorCompletionService<>(
				executor);

		for (Callable<BigInteger> task : Collections.nCopies(tasks,
				new Callable<BigInteger>() {
					@Override
					public BigInteger call() throws Exception {
						return alg.next();
					}
				})) {
			sc.submit(task);
		}
		
		Future<BigInteger> result;
		while( (result =  sc.poll()) != null ){
			System.out.println( result.get() );
		}
		
		executor.shutdown();

	}
}
