package tw.com.rtsocial.bot.serviceImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import tw.com.rtsocial.bot.domain.UserinfoBean;
import tw.com.rtsocial.bot.repository.UserinfoRepository;
import tw.com.rtsocial.bot.service.UserinfoService;
import tw.com.rtsocial.bot.utils.DatabaseUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserinfoServiceImp implements UserinfoService {

	@Autowired
	UserinfoRepository repository;

	// 新增
	@Override
	public Object addUserInfo(UserinfoBean userInfoBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserinfoBean> getAllUserInfo() {
		List<UserinfoBean> result = repository.findAll();

		if (!result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public List<UserinfoBean> getUserInfofindByUserid(String userid) {
		List<UserinfoBean> result = repository.findByUserid(userid);

		if (!result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public List<UserinfoBean> getUserInfofindfindByUsermail(String usermail) {
		List<UserinfoBean> result = repository.findByUsermail(usermail);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}
	//登入後的比對
	@Override
	public Object updateUserInfo(String usermail, UserinfoBean userInfoBean) {
		
		List<UserinfoBean> userInfo = repository.findByUsermail(usermail);
		
		if (userInfo.size() == 1) {
			UserinfoBean currentUserInfo = userInfo.get(0);
			
			userInfoBean.setId(currentUserInfo.getId());
			userInfoBean.setUserid(currentUserInfo.getUserid());
			userInfoBean.setReviseid(currentUserInfo.getReviseid());
			userInfoBean.setRevisetime(new Date());
			userInfoBean.setUsertoken(DatabaseUtils.createSQLtoken(userInfoBean.getUsertoken()) );
			try {
				repository.save(userInfoBean);
				return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} 
		return new ResponseEntity<String>("資料不存在：UserMail", HttpStatus.NOT_FOUND);
	}

}
