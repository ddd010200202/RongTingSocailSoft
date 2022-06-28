//package tw.com.rtsocial.bot.controller;
//
//import java.util.HashMap;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import tw.com.rtsocial.bot.utils.JwtTokenUtils;
//
//@RestController
//@RequestMapping("/api")
//public class LoginController {
//
//@PostMapping("/login")
//public ResponseEntity login(@RequestBody HashMap <String, String> user) {
//    JwtTokenUtils jwtToken = new JwtTokenUtils();
//    String token = jwtToken.generateToken(user); // 取得token
//
//    return ResponseEntity.status(HttpStatus.OK).body(token);
//   }
//}