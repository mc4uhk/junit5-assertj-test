package hk.mc4u.junit5test;

import java.io.File;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheHelper2 {

	private CacheManager cacheManager;
	private Cache<Integer, Integer> squareNumberCache;

	private Map<Integer, Integer> squareNumberMap;
	
	
	public CacheHelper2() {
		String tmpdir =System.getProperty("java.io.tmpdir"); 
		String fs = File.separator;
		String str = getRandomHexString(4)+"-"+getRandomHexString(4);
		log.info("tmpdir: {}",tmpdir);
		log.info("str: {}",str);
		String cachePath = tmpdir+fs+str;
		log.info("cachePath : {}",cachePath );
		File tmpCachePath = new File(cachePath);
		tmpCachePath.deleteOnExit();
		cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
				.with(CacheManagerBuilder.persistence(tmpCachePath))
				.withCache("persistent-cache",
						CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, Integer.class,
								ResourcePoolsBuilder.newResourcePoolsBuilder()
								.heap(10, EntryUnit.ENTRIES)
								.offheap(20, MemoryUnit.MB)
								.disk(100, MemoryUnit.MB, true)))
				.build(true);

		squareNumberCache = cacheManager.createCache("squaredNumber", CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Integer.class, Integer.class, ResourcePoolsBuilder.heap(10)));
		
	}

	public void close() {
		cacheManager.close();
	}
	
	public Cache<Integer, Integer> getSquareNumberCacheFromCacheManager() {
		return cacheManager.getCache("squaredNumber", Integer.class, Integer.class);
	}

	public Cache<Integer, Integer> getSquareNumberCache() {
		return squareNumberCache;
	}

	public Map<Integer, Integer> getSquareNumberCache01() {
		return squareNumberMap;
	}

	public void setSquareNumberCache(Cache<Integer, Integer> squareNumberCache) {
		this.squareNumberCache = squareNumberCache;
	}

	// standard getters and setters
	
    private String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }	    
    
    private void temp() {
    	CompletableFuture<Long> completableFuture = CompletableFuture .supplyAsync(null);
    	while (!completableFuture.isDone()) {
    	    System.out.println("CompletableFuture is not finished yet...");
    	}
    }
	
}
