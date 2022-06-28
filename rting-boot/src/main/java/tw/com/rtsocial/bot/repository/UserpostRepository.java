package tw.com.rtsocial.bot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.com.rtsocial.bot.domain.UserpostBean;

public interface UserpostRepository extends JpaRepository<UserpostBean, Integer> {
	//藉由userid查詢post
	List<UserpostBean> findByUserid(String userid);
}
