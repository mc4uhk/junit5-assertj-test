package hk.mc4u.junit5test;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test08 {
	@Test
	public void test01() throws Exception {
		CacheHelper helper = new CacheHelper();
		
		while(true) {
			Integer value = helper.getSquareNumberCache().get(1);
			log.info(value+"");
			if(value == null)
				helper.getSquareNumberCache().put(1, 99);
			Thread.sleep(1000);
		}
		
	}
}
