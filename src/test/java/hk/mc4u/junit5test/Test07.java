package hk.mc4u.junit5test;

import org.junit.jupiter.api.Test;

public class Test07 {
	@Test
	public void test01() throws Exception {
		var jsonStr2 = """
				[
				{name: "dsahjd"},
				{name: "dksakj"},
				]
				""";

		System.out.println(jsonStr2);
		
	}
}
