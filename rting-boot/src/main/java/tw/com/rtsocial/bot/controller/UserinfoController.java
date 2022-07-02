package tw.com.rtsocial.bot.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tw.com.rtsocial.bot.service.UserinfoService;
import tw.com.rtsocial.bot.utils.DatabaseUtils;
import tw.com.rtsocial.bot.utils.FirebaseUtils;


@Api(tags = "使用者資訊api")
@RestController
@RequestMapping("/api")
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private FirebaseUtils firebaseUtils;

	@ApiOperation("查詢使用者資料")
	@GetMapping("/users")
	public Object getUserinfo(@RequestParam(name = "userid", required = false) String userid,
			@RequestParam(name = "usermail", required = false) String usermail, @RequestHeader HttpHeaders header) {
			
		String token = header.getFirst(HttpHeaders.AUTHORIZATION);
		List<String> tokenInfo = firebaseUtils.verify(token);

		if(!tokenInfo.isEmpty()&&tokenInfo.size()>0&&DatabaseUtils
				.verfiySQLtoken(tokenInfo.get(0),userinfoService
						.getUserInfofindfindByUsermail(tokenInfo.get(2)).get(0).getUsertoken())) {
			if (userid != null && userid.trim().length() != 0) {
				if (userinfoService.getUserInfofindByUserid(userid) == null) {
					System.out.println("用id找到");
					return "找不到此使用者";
				} else {
						return userinfoService.getUserInfofindByUserid(userid);
				}

			} else if (usermail != null && usermail.trim().length() != 0) {
				if (userinfoService.getUserInfofindfindByUsermail(usermail) == null) {
					return "找不到此使用者";
				} else {
					System.out.println("用信箱找到");
					return userinfoService.getUserInfofindfindByUsermail(usermail);
				}

			} else {
				
				System.out.println("找全部");
				return userinfoService.getAllUserInfo();
			}
		}else {
			return "權限不足";
		}
		
		
		

	}
}
