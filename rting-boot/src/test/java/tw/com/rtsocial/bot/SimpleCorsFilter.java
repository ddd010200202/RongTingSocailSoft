package tw.com.rtsocial.bot;
//package tw.com.rtsocial.bot.config;
//
//import java.io.IOException;
//
//
//import javax.servlet.FilterChain;
//
//import javax.servlet.ServletException;
//
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//
//public class SimpleCorsFilter extends OncePerRequestFilter  {
//    
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		final HttpServletResponse response1 = (HttpServletResponse)response;
//	    final HttpServletRequest request1 = (HttpServletRequest)request;
//	    response1.setHeader("Access-Control-Allow-Origin", "*");
//	    response1.setHeader("Access-Control-Allow-Credentials","true");
//	    response1.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
//	    response1.setHeader("Access-Control-Max-Age", "3600");
//	    response1.setHeader("Access-Control-Allow-Headers", "content-type, x-requested-with, Authorization");
//	    if (request1.getMethod()!=null&&request1.getMethod().equals("OPTIONS")) {
//	        response1.setStatus(HttpServletResponse.SC_OK);
//	        System.out.println("123");
//	    } else {
//	    	filterChain.doFilter(request1, response1);
//	    	 System.out.println("456");
//	    }
//		
////		long startTime = System.currentTimeMillis();
////		filterChain.doFilter(request, response);
////	    long processTime = System.currentTimeMillis() - startTime;
////
////	    System.out.println(processTime + " ms");
//	}
//
//}
