package tw.com.rtsocial.bot.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.rtsocial.bot.domain.UserinfoBean;
import tw.com.rtsocial.bot.repository.UserinfoRepository;
import tw.com.rtsocial.bot.service.UserinfoService;

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

	@Override
	public Object updateUserInfo(String userid, UserinfoBean userInfoBean) {
		// TODO Auto-generated method stub
		return null;
	}

}
