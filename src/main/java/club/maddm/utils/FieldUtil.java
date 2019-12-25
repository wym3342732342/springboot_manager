package club.maddm.utils;


import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 为实体字段工具类
 * 
 * */
public class FieldUtil {

	/**
	 * 统一为实体添加公共字段内容，新增调用
	 * 	<p>
	 * 		调用该方法必须包含 新增 人&时间，修改 人&时间 逻辑删除字段
	 * 	</P>
	 * @param t 实体
	 * @ param user 当前登录人信息
	 * 
	 * */
	public static void setAddFieldValue(Object t,String userName) throws Exception{
		Method creatTime = t.getClass().getMethod("setCreatedTime", Date.class);
		creatTime.invoke(t, new Date());
		
		Method creatName = t.getClass().getMethod("setCreatedBy", String.class);
		creatName.invoke(t,userName);

		Method updateTime = t.getClass().getMethod("setUpdatedTime", Date.class);
		updateTime.invoke(t, new Date());

		Method updateName = t.getClass().getMethod("setUpdatedBy", String.class);
		updateName.invoke(t,userName);

		Method status = t.getClass().getMethod("setFlag", String.class);
		status.invoke(t, "0");
	}
}
