package hk.mc4u.junit5test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheHelper {

	private Map<Integer, Integer> squareNumberCache = new HashMap<>();

	
	public CacheHelper() {
    	startloop();
	}


	public Map<Integer, Integer> getSquareNumberCache() {
		return squareNumberCache;
	}


    
    private void startloop() {
    	CompletableFuture
    	.runAsync(this::sleep)
    	.thenRunAsync(this::resetCache);
    }
	
    private void sleep() {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    private void resetCache() {
    	log.info("Reset");
    	squareNumberCache.clear();
    	startloop();
    }
}
