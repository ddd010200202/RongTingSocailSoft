//package tw.com.rtsocial.bot.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
////			「/users」這個 API 及其底下的所有 GET 請求，需通過身份驗證才可存取。
////			其餘 API 的所有GET請求，允許所有呼叫方存取。
////			「/users」這個 API 的 POST 請求，允許所有呼叫方存取。
////			其餘的所有 API，需通過身份驗證才可存取。
////			「*」：代表0到多個字元。如「/products/*」適用於「/products」、「/products/123」，但不適用「/products/123/draft」
////			「**」：代表0到多個路徑。如「/products/**」適用於「/products」底下任何路徑。
////			「?」：代表一個字元。如「/products/?*」適用於「/products/1」、「/products/123」，但不適用「/products」。
//			http
//	
//	        .authorizeRequests()
//	        .antMatchers(HttpMethod.GET, "/users").authenticated()
//	        .antMatchers(HttpMethod.GET).permitAll()
//	        .antMatchers(HttpMethod.POST, "/users").permitAll()
////	        .anyRequest().authenticated()
//	        .and()
////	        .oauth2Login();
//	        .csrf().disable()
//	        .formLogin();
//		}
//}
