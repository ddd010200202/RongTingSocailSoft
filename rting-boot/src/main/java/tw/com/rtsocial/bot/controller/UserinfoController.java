package tw.com.rtsocial.bot.controller;

import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

import tw.com.rtsocial.bot.service.UserinfoService;
import tw.com.rtsocial.bot.utils.JWTUtil;

//@Api(tags = "使用者資訊api")
@RestController
@RequestMapping("/api")
public class UserinfoController {

	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private JWTUtil util;

//	@ApiOperation("查詢使用者資料")
	@GetMapping("/users")
	public Object getUserinfo(@RequestParam(name = "userid", required = false) String userid,
			@RequestParam(name = "usermail", required = false) String usermail, @RequestHeader HttpHeaders header) {
//			
//		String value = header.getFirst(HttpHeaders.AUTHORIZATION);
		

		System.out.println(header);
		if (userid != null && userid.trim().length() != 0) {
			if (userinfoService.getUserInfofindByUserid(userid) == null) {
				return "找不到此使用者";
			} else {
				return userinfoService.getUserInfofindByUserid(userid);
			}

		} else if (usermail != null && usermail.trim().length() != 0) {
			if (userinfoService.getUserInfofindByUserid(userid) == null) {
				return "找不到此使用者";
			} else {
				return userinfoService.getUserInfofindfindByUsermail(usermail);
			}

		} else {
			return userinfoService.getAllUserInfo();
		}

	}
}
