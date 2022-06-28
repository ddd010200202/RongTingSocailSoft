package tw.com.rtsocial.bot;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RtingBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtingBootApplication.class, args);
	}

}
