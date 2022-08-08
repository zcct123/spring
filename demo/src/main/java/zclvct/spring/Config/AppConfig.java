package zclvct.spring.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zclvct.Processor.FirstBeanDefinitionRegistryPostProcessor;
import zclvct.spring.service.OrderService;
import zclvct.spring.service.UserService;
import zclvct.spring.serviceimpl.OrderServiceImpls;
import zclvct.spring.serviceimpl.UserServiceImpl;

/**
 * @description:
 * @projectName:spring
 * @see:Config
 * @author:赵冲
 * @createTime:2021/8/3 12:24
 * @version:1.0
 */
@ComponentScan({"zclvct.spring.aop","zclvct.spring.*"})
@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class AppConfig {

	@Bean(autowireCandidate = false)
	public OrderService orderService1 (){
		return  new OrderServiceImpls();
	}

	@Bean
	public OrderService orderService2 (){
		return  new OrderServiceImpls();
	}

	@Bean
	public OrderService orderService3 (){
		return  new OrderServiceImpls();
	}

	@Bean
	@Qualifier("orderQualifier")
	public OrderService orderService4 (){
		return  new OrderServiceImpls();
	}
	@Bean
	@Qualifier("orderQualifier")
	@Primary
	public OrderService orderService5 (){
		return  new OrderServiceImpls();
	}

	@Bean
	public FirstBeanDefinitionRegistryPostProcessor firstBeanDefinitionRegistryPostProcessor (){
		return  new FirstBeanDefinitionRegistryPostProcessor();
	}

	@Bean(name = "messageSource")
	public MessageSource getMessageSource() {

		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setDefaultEncoding("UTF-8");
		messageSource.addBasenames("message", "message_en");

		return messageSource;

	}
}
