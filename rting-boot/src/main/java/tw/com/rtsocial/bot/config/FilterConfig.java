//package tw.com.rtsocial.bot.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean logProcessTimeFilter() {
//        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();
//        bean.setFilter(new CorsFilter());
//        bean.addUrlPatterns("/*");
//        bean.setName("SimpleCorsFilter");
//
//        return bean;
//    }
//}