package tw.com.rtsocial.bot;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordTests {
	@Test
	void contextLoads() {
	}
	@Autowired
	private StringEncryptor encryptor;
	
	@Test
	public void testEncrypt() {
		String root = encryptor.encrypt("root");
		System.out.println("root="+root);
	}
//	@Test
	public void testDecrypt() {
		String result1 = encryptor.decrypt(
				"3hSakpXJJQUMICmrOE/KXCuKy5xeK5/yigvPJ32qGwZJz+xArx51Dgi53T6rxTGc");
		System.out.println("result1="+result1);
		
		String result2 = encryptor.decrypt(
				"r2quow0qb8+V80QIWcEYrHZn7WAFAA8oem4xb0FU+2dNJAYQ94Pj/5ks4i3IJklM");
		System.out.println("result2="+result2);
	}
}
