package tw.com.rtsocial.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.rtsocial.bot.domain.UserinfoBean;
@Repository
public interface UserinfoRepository extends JpaRepository<UserinfoBean, Integer>{
	//資料儲存曾
	//搜尋 by userid
	List<UserinfoBean> findByUserid(String userid);
	//搜尋 by mail
	List<UserinfoBean> findByUsermail(String usermail);
	
}
