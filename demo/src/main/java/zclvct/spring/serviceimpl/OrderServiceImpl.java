package zclvct.spring.serviceimpl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import zclvct.spring.entity.User;
import zclvct.spring.service.OrderService;
import zclvct.spring.service.UserService;

import javax.annotation.Resource;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 15:27
 */
@Service
public class OrderServiceImpl implements   InitializingBean {

	@Resource
	private UserService userService;

	private User user;


	public void test(){
		System.out.println("OrderService");
		System.out.println(user.toString());
	}

	// 初始化 bean
	@Override
	public void afterPropertiesSet() throws Exception {
		user = new User("测试账号","123456");
	}
}
