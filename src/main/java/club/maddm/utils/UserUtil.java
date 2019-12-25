package club.maddm.utils;

import club.maddm.common.entity.User;
import club.maddm.common.entity.vo.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *  用户工具类
 * 
 * */
public class UserUtil {
	/**
	 * 获取当前登录人信息
	 * 
	 * */
	public static UserInfo getUserDetail(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUserInfo();
	}
}