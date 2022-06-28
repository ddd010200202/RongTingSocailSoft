//import org.springframework.cglib.core.Converter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.authorization.AuthorizationManager;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.filter.CorsFilter;
//
//import lombok.AllArgsConstructor;
//
//@AllArgsConstructor
//@Configuration
//@EnableWebFluxSecurity
//public class SecurityFilter {
//    private final AuthorizationManager authorizationManager;
////    private final IgnoreUrlsConfig ignoreUrlsConfig;
////    private final RestfulAccessDeniedHandler restfulAccessDeniedHandler;
////    private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
////    private final IgnoreUrlsRemoveJwtFilter ignoreUrlsRemoveJwtFilter;
//
////    private final UrlJwtFilter urlJwtFilter;
//
//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//
//        http.cors().and().csrf().disable();
//        // 增加自定义拦截器
//        http.addFilterAt(new CorsFilter(), SecurityWebFiltersOrder.SECURITY_CONTEXT_SERVER_WEB_EXCHANGE);
//        //自定义处理JWT请求头过期或签名错误的结果
//        http.oauth2ResourceServer().authenticationEntryPoint(restAuthenticationEntryPoint);
//        http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter());
//        //用于解决没办法设置Header的token
//        http.addFilterBefore(urlJwtFilter, SecurityWebFiltersOrder.AUTHENTICATION);
//        //对白名单路径，直接移除JWT请求头
//        http.addFilterBefore(ignoreUrlsRemoveJwtFilter, SecurityWebFiltersOrder.AUTHENTICATION);
//        http.authorizeExchange()
//                .pathMatchers(ArrayUtil.toArray(ignoreUrlsConfig.getUrls(),String.class)).permitAll()//白名单配置
//             .pathMatchers("/**").permitAll(); 放開所有請求，不攔截
//        return http.build();
//    }
//
//    @Bean
//    public Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>> jwtAuthenticationConverter() {
//        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
//        jwtGrantedAuthoritiesConverter.setAuthorityPrefix(AuthConstant.AUTHORITY_PREFIX);
//        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName(AuthConstant.AUTHORITY_CLAIM_NAME);
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
//    }
//
//}