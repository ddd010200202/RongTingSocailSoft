//package tw.com.rtsocial.bot.utils;
//
//import javax.naming.AuthenticationException;
//
//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.mapstruct.Qualifier;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;

//@Component
//public class FirebaseAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    @Qualifier(value = UserServiceImpl.NAME)
//    private UserDetailsService userService;
//
//    public boolean supports(Class<?> authentication) {
//        return (FirebaseAuthenticationToken.class.isAssignableFrom(authentication));
//    }
//
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        if (!supports(authentication.getClass())) {
//            return null;
//        }
//
//        FirebaseAuthenticationToken authenticationToken = (FirebaseAuthenticationToken) authentication;
//        UserDetails details = userService.loadUserByUsername(authenticationToken.getName());
//        if (details == null) {
//            throw new FirebaseUserNotExistsException();
//        }
//
//        authenticationToken = new FirebaseAuthenticationToken(details, authentication.getCredentials(),
//                details.getAuthorities());
//
//        return authenticationToken;
//    }

//}