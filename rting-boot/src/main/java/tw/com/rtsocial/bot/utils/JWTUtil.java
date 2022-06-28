package tw.com.rtsocial.bot.utils;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.logging.log4j.util.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.stereotype.Component;

import com.nimbusds.oauth2.sdk.id.Audience;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：pyy
 * Date：2019/7/17 17:24
 * Version: v1.0
 * ========================
 */
@Component
public class JWTUtil {

//    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);

    public static final String AUTH_HEADER_KEY = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 解析jwt
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
//    public static Claims parseJWT(/*String jsonWebToken, String base64Security*/) {
//    		
//        return Jwts.parser().setSigningKey("YRJmZHh3x0w7QzT2O63vlBkFYxkXhur0vUwIAbxN9EpPc9sjXvkfAgJ5SaWmyaK8").parseClaimsJws(
//    			"eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk4OTdjZjk0NTllMjU0ZmYxYzY3YTRlYjZlZmVhNTJmMjFhOWJhMTQiLCJ0eXAiOiJKV1QifQ.eyJuYW1lIjoiUm9uZ1RpbmcgV3UiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFUWEFKemFTV0NodGdKMThTZ2RnUFVBSE5aVDB2NVBvV09VSDA4SGMwaDY9czk2LWMiLCJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcm9uZ3Rpbmdjb21wYW55LWFiM2I3IiwiYXVkIjoicm9uZ3Rpbmdjb21wYW55LWFiM2I3IiwiYXV0aF90aW1lIjoxNjU2MjU5Njg4LCJ1c2VyX2lkIjoiU1lZS3k0VE53MVNWQnBOY0g5ZGVqTTFFT2tsMSIsInN1YiI6IlNZWUt5NFROdzFTVkJwTmNIOWRlak0xRU9rbDEiLCJpYXQiOjE2NTYzOTM1NDksImV4cCI6MTY1NjM5NzE0OSwiZW1haWwiOiJyb25ndGluZ2NvbXBhbnlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsicm9uZ3Rpbmdjb21wYW55QGdtYWlsLmNvbSJdfSwic2lnbl9pbl9wcm92aWRlciI6InBhc3N3b3JkIn19.t_vd24nwan2KgaRwF5TbrWvoKRDiiLcAkMoI8bjZkNcPTSH6UPmEjtIYzaeQ66KdRwnH6W0OflVwncJsrSmh8ItoJNREHBAAvagXK0TgbqQRcyZ_7glErfnq_lt9yl33xqjDi6d04SGf81ftu8Cb6FrFqVnV7Y5boo9hGLN2Q9IJnVDBOg-2Fjv4rv7rk_DsvwCyJHFR2EVflqo0lf2IM1qPLBW_sEk4bob8W4ZGgQd6R3058IE3f65gK1iVXiLGylZLdztrGW66wkelasw362xjM6-I9uMWS5u7sraPFR0o8HXN4yfPnOTttVFfLwXvQeYks30NFh8JhTQOH7NS1A"    			
//    			).getBody();
//    }

//    /**
//     * 构建jwt
//     * @param userId
//     * @param username
//     * @param role
//     * @param audience
//     * @return
//     */
//    public static String createJWT(String userId, String username, String role, Audience audience) {
//        try {
//            // 使用HS256加密算法
//            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//            long nowMillis = System.currentTimeMillis();
//            Date now = new Date(nowMillis);
//
//            //生成签名密钥
//            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
//            Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//            //userId是重要信息，进行加密下
//            String encryId = Base64Util.encode(userId);
//
//            //添加构成JWT的参数
//            JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
//                    // 可以将基本不重要的对象信息放到claims
//                    .claim("role", role)
//                    .claim("userId", userId)
//                    .setSubject(username)           // 代表这个JWT的主体，即它的所有人
//                    .setIssuer(audience.getClientId())              // 代表这个JWT的签发主体；
//                    .setIssuedAt(new Date())        // 是一个时间戳，代表这个JWT的签发时间；
//                    .setAudience(audience.getName())          // 代表这个JWT的接收对象；
//                    .signWith(signatureAlgorithm, signingKey);
//            //添加Token过期时间
//            int TTLMillis = audience.getExpiresSecond();
//            if (TTLMillis >= 0) {
//                long expMillis = nowMillis + TTLMillis;
//                Date exp = new Date(expMillis);
//                builder.setExpiration(exp)  // 是一个时间戳，代表这个JWT的过期时间；
//                        .setNotBefore(now); // 是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
//            }
//
//            //生成JWT
//            return builder.compact();
//        } catch (Exception e) {
//            log.error("签名失败", e);
//            throw new CustomException(ResultCode.PERMISSION_SIGNATURE_ERROR);
//        }
//    }
//
//    /**
//     * 从token中获取用户名
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static String getUsername(String token, String base64Security){
//        return parseJWT(token, base64Security).getSubject();
//    }
//
//    /**
//     * 从token中获取用户ID
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static String getUserId(String token, String base64Security){
//        String userId = parseJWT(token, base64Security).get("userId", String.class);
//        return Base64Util.encode(userId);
//    }
//
//    /**
//     * 是否已过期
//     * @param token
//     * @param base64Security
//     * @return
//     */
//    public static boolean isExpiration(String token, String base64Security) {
//        return parseJWT(token, base64Security).getExpiration().before(new Date());
//    }
}