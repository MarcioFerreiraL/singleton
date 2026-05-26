package com.padroesprojeto.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

import com.padroesprojeto.singleton.versions.EagerSingleton;
import com.padroesprojeto.singleton.versions.SimpleSingleton;
import com.padroesprojeto.singleton.versions.SynchronizedSingleton;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SingletonApplicationTests {

	@Test
	void givenUnsafeSingleton_whenAccessedConcurrently_thenMultipleInstancesCreated() throws InterruptedException {
		int threadCount = 10;
		Set<SimpleSingleton> instances = ConcurrentHashMap.newKeySet();
		CountDownLatch latch = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			new Thread(() -> {
				instances.add(SimpleSingleton.getInstance());
				latch.countDown();
			}).start();
		}
		latch.await();
		assertTrue(instances.size() > 1, "Multiplas instâncias foram criadas");
	}

	@Test
	void givenMultipleThreads_whenUsingSynchronizedSingleton_thenOnlyOneInstanceCreated() {
		Set<Object> instances = ConcurrentHashMap.newKeySet();
		IntStream.range(0, 100).parallel().forEach(i ->
		instances.add(SynchronizedSingleton.getInstance()));
		assertEquals(1, instances.size());
	}
	@Test
	void whenCallingEagerSingleton_thenSameInstanceReturned() {
    assertSame(EagerSingleton.getInstance(), EagerSingleton.getInstance());
	}

}
