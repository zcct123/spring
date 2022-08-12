package zclvct.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import zclvct.spring.Config.AppConfig;
import zclvct.spring.common.MyStartupStep;
import zclvct.spring.event.MyPublisher;
import zclvct.spring.service.DaoService;
import zclvct.spring.service.UserService;
import zclvct.spring.serviceimpl.DaoServiceImpl;
import zclvct.spring.serviceimpl.OrderServiceImpl;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/**
 * @description:
 * @projectName:spring
 * @see:main
 * @author:??
 * @createTime:2021/8/3 12:26
 * @version:1.0
 */

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		UserService userService = (UserService)applicationContext.getBean(UserService.class);
		UserService userService = (UserService)applicationContext.getBean(UserService.class);

		userService.test();

//		OrderServiceImpl orderServiceImpl = (OrderServiceImpl)applicationContext.getBean(OrderServiceImpl.class);
//
//		orderServiceImpl.test();
//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//		Arrays.asList(beanDefinitionNames).forEach(item ->{
//			Object bean = applicationContext.getBean(item);
//			System.out.printf(item+"=====");
//			System.out.println(bean);
//		});

//		DaoService bean = applicationContext.getBean(DaoService.class);
//		bean.insert();
//		Map<String, Object> select = bean.select(18);
//		System.out.println(select);

// ?????
//		MessageSource messageSource = applicationContext.getBean(MessageSource.class);
//		String zhMessage = messageSource.getMessage("base.response.success.msg", null, null, Locale.CHINA);
//		String enMessage = messageSource.getMessage("base.response.fail.msg", null, null, Locale.ENGLISH);
//		System.out.println("zhMessage = " + zhMessage);
//		System.out.println("enMessage = " + enMessage);

		MyPublisher myPublisher = (MyPublisher)applicationContext.getBean("myPublisher");
		myPublisher.doPublisher("今天晚上吃啥");
		UserService bean = applicationContext.getBean(UserService.class);
		bean.test();
	}
}
