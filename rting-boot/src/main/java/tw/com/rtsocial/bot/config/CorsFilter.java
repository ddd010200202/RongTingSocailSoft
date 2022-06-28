//package tw.com.rtsocial.bot.config;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class CorsFilter implements Filter {
// @Override
// public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//  
//  HttpServletResponse response = (HttpServletResponse) servletResponse;
//  HttpServletRequest request= (HttpServletRequest) servletRequest;
//  // addAllowedOrigin 不能設定為* 因為與 allowCredential 衝突
//  response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500/");
//  response.setHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
//  response.setHeader("Access-Control-Allow-Headers", "*");        
//  response.setHeader("Access-Control-Allow-Credentials", "true");
//  response.setHeader("Access-Control-Max-Age", "180");
//  System.out.println("123");
//  if(request.getMethod()!=null&&request.getMethod().equals("OPTIONS")) 
//	  return;
//  filterChain.doFilter(servletRequest, servletResponse);
//    }
// 
//}
