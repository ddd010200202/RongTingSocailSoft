package tw.com.rtsocial.bot.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;


@Configuration
public class FirebaseConfig {
	@Value("rongtingcompany-ab3b7-firebase-adminsdk-ip4wi-6174b2100e.json")
	private String testFile;

	@Bean
	public void fireTips() {
//      ClassPathResource resource = new ClassPathResource("rongtingcompany-ab3b7-firebase-adminsdk-ip4wi-6174b2100e.json"); // 直接寫檔名 路徑：src/main/resources/
		ClassPathResource resource = new ClassPathResource(testFile);// 取得變數的檔名
//      Resource resource = new ClassPathResource(ruyutFile2);//取得變數的檔名(在static資料夾下)
//     	 Resource resource = new ClassPathResource(ruyutFile3);//使用springBoot的自動裝配，讀取設定檔內的文字
		File file = null;
		
		
		try {
			file = resource.getFile();
			InputStream inputStream = new FileInputStream(file);
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(inputStream))
//	          		.setDatabaseUrl("https://rongtingcompany-ab3b7.firebaseio.com/")
					.build();
			if (FirebaseApp.getApps().isEmpty()) {
				  FirebaseApp.initializeApp(options);
			} 

		} catch (IOException e) {

		}
	}
}
