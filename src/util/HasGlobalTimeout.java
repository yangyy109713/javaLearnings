package util;

import java.util.concurrent.*;

import org.junit.rules.Timeout;
import org.junit.Rule;
import org.junit.Test;

public class HasGlobalTimeout {
	public static String log;
	private final CountDownLatch latch = new CountDownLatch(1);
	
	@Rule
	//public Timeout globalTimeout = Timeout.seconds(10);
	
	@Test
    public void testSleepForTooLong() throws Exception {
        log += "ran1";
        TimeUnit.SECONDS.sleep(100); // sleep for 100 seconds
    }

    @Test
    public void testBlockForever() throws Exception {
        log += "ran2";
        latch.await(); // will block 
    }
}