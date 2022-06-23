package tw.com.rtsocial.bot.service;

import java.util.List;

import tw.com.rtsocial.bot.domain.UserinfoBean;

public interface UserinfoService {
	// 新增單筆使用者資料
    public Object addUserInfo(UserinfoBean userInfoBean);
    
    // 取得全部使用者資料
    public List<UserinfoBean> getAllUserInfo();
    
    // 取得單筆使用者資料 by UserId
    public List<UserinfoBean> getUserInfofindByUserid(String userid);
    
    // 取得單筆使用者資料 by UserMail
    public List<UserinfoBean> getUserInfofindfindByUsermail(String usermail);
    
    // 更新單筆使用者資料
    public Object updateUserInfo(String userid, UserinfoBean userInfoBean);
}
