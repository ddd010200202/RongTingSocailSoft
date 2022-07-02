package tw.com.rtsocial.bot.utils;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUtils {
	
	public static String createSQLtoken(String uid) {
		return BCrypt.hashpw(uid, BCrypt.gensalt(13));
	}
	public static Boolean verfiySQLtoken(String uid,String tokenuid) {
		
		return BCrypt.checkpw(uid, tokenuid);
	}
}
