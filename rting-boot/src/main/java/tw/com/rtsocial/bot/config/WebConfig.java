//package tw.com.rtsocial.bot.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@Configuration
//
//public class WebConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//    	registry.addMapping("/**")
//    			.allowedOrigins("http://127.0.0.1:5500")
//    			.allowedHeaders("*")
//    			.allowedMethods("*")
//    			.maxAge(30*1000)
//    			;
//    			
//    }
//}