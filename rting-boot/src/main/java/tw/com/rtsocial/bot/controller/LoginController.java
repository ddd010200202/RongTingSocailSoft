package tw.com.rtsocial.bot.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tw.com.rtsocial.bot.domain.UserinfoBean;
import tw.com.rtsocial.bot.service.UserinfoService;
import tw.com.rtsocial.bot.utils.FirebaseUtils;



@Api(tags = "提供資料庫連線token")
@RestController
@RequestMapping("/api")

public class LoginController {
	
	@Autowired
	private FirebaseUtils firebaseUtils;
	@Autowired
	private UserinfoService userinfoService;
	
	
	@ApiOperation("Token")
	@PutMapping("/putToken")
	public Object getToken(@RequestHeader HttpHeaders header,@RequestBody UserinfoBean userinfoBean) {
		String token = header.getFirst(HttpHeaders.AUTHORIZATION);
		List<String> tokenInfo = firebaseUtils.verify(token);
		System.out.println(userinfoBean);
		
		if(!tokenInfo.isEmpty()&&tokenInfo.size()>0) {
			if (userinfoBean != null) {
				return userinfoService.updateUserInfo(tokenInfo.get(2), userinfoBean);
			} else {
				return new ResponseEntity<String>("Input不存在", HttpStatus.NOT_FOUND);
			}
			
		}else {
			return "權限不足";
		}
		
		
	}
}