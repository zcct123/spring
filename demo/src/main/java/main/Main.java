package main;

import Config.AppConfig;
import common.MyStartupStep;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.UserService;

/**
 * @description:
 * @projectName:spring
 * @see:main
 * @author:赵冲
 * @createTime:2021/8/3 12:26
 * @version:1.0
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		applicationContext.setApplicationStartup(new MyStartupStep());
		UserService userService = (UserService)applicationContext.getBean("userService");
		userService.test();
	}
}
