package zclvct.spring.wirteSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zclvct.spring.Config.AppConfig;
import zclvct.spring.common.MyStartupStep;
import zclvct.spring.service.UserService;

import java.util.Arrays;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 15:17
 */
public class test {
	public static void main(String[] args) {
		// 创建spring容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.test();

	}
}
