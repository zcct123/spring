package zclvct.plus;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import zclvct.Processor.FirstBeanDefinitionRegistryPostProcessor;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/9/8 13:13
 */
public class SpringApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		FirstBeanDefinitionRegistryPostProcessor firstBeanDefinitionRegistryPostProcessor = new FirstBeanDefinitionRegistryPostProcessor();
		// 将自定义的firstBeanDefinitionRegistryPostProcessor添加到应用上下文中
		applicationContext.addBeanFactoryPostProcessor(firstBeanDefinitionRegistryPostProcessor);
		// ...自定义操作
		System.out.println("SpringApplicationContextInitializer#initialize");
	}
}