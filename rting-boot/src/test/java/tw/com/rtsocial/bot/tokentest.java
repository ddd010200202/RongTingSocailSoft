package tw.com.rtsocial.bot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.cloud.FirestoreClient;
import com.google.rpc.context.AttributeContext.Resource;




@SpringBootTest
public class tokentest {
	 @Value("rongtingcompany-ab3b7-firebase-adminsdk-ip4wi-6174b2100e.json")
	 private String testFile;
	
	@Test
	void contextLoads() {
	}
	@Test
	public void tokentest() {
//		System.out.println(testFile);
	}
//	@Test
//    public void initialize() {
////        ClassPathResource resource = new ClassPathResource("rongtingcompany-ab3b7-firebase-adminsdk-ip4wi-6174b2100e.json"); // 直接寫檔名 路徑：src/main/resources/
//        ClassPathResource resource = new ClassPathResource(testFile);//取得變數的檔名
////        Resource resource = new ClassPathResource(ruyutFile2);//取得變數的檔名(在static資料夾下)
////        Resource resource = new ClassPathResource(ruyutFile3);//使用springBoot的自動裝配，讀取設定檔內的文字
//        File file = null;
//        String token ="eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk4OTdjZjk0NTllMjU0ZmYxYzY3YTRlYjZlZmVhNTJmMjFhOWJhMTQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiUm9uZ1RpbmcgV3UiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFUWEFKemFTV0NodGdKMThTZ2RnUFVBSE5aVDB2NVBvV09VSDA4SGMwaDY9czk2LWMiLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcm9uZ3Rpbmdjb21wYW55LWFiM2I3IiwiYXVkIjoicm9uZ3Rpbmdjb21wYW55LWFiM2I3IiwiYXV0aF90aW1lIjoxNjU2MjU5Njg4LCJ1c2VyX2lkIjoiU1lZS3k0VE53MVNWQnBOY0g5ZGVqTTFFT2tsMSIsInN1YiI6IlNZWUt5NFROdzFTVkJwTmNIOWRlak0xRU9rbDEiLCJpYXQiOjE2NTY1NjA3NDUsImV4cCI6MTY1NjU2NDM0NSwiZW1haWwiOiJyb25ndGluZ2NvbXBhbnlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsicm9uZ3Rpbmdjb21wYW55QGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.vdecoQmI5t6VAhpQH83mwHvHdEe8UtAzCAfMwBTdAAlWUAzUrLzPUrBgi6G8G-tZM4eDafP2lsz5jywBQQruUiHVndWMQgqo9EBhgBDNfPDO3PXf_9qkZT7NDbft6Xk8859CR45iSvjS47Qg1P33g-km_TqUHmbC24Xp3TZwH50vQZjHtp6UMtieDZejRpmoBEi7T3s-8gtHYyaEiSQy1DnccTHKhA9hYmmy5zPvQGvVb3_HE4YgT5f8qOcdaW6XImKiFPlUzYZTXjkF_wTm6Rl2hq2lWT04-PK_fw-u44KFHypj_imx2Ze83izCdaq2NFkYhW3sdmY5dqByQOwEbQ";
//        try {
//            file = resource.getFile();
//            InputStream inputStream =new FileInputStream(file);
//            FirebaseOptions options =new FirebaseOptions.Builder()
//            		.setCredentials(GoogleCredentials.fromStream(inputStream))
////            		.setDatabaseUrl("https://rongtingcompany-ab3b7.firebaseio.com/")
//            		.build();
//            FirebaseApp.initializeApp(options);
//            
//            Firestore db =FirestoreClient.getFirestore();
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
//     	   	String uid = decodedToken.getUid();
//     	   	String Email  =decodedToken.getEmail();
//     	   	String Name=decodedToken.getName();
//            System.out.println(uid);
//            System.out.println(Email);
//            System.out.println(Name);
//
//        } catch (FirebaseAuthException | IOException e) {
//            e.printStackTrace();
//        }
//    }
}
