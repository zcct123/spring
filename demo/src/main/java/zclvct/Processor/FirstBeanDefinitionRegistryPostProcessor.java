package zclvct.Processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author zcct
 * @version 1.0
 * @description: BeanFactoryPostProcessor
 * @date 2021/9/8 13:14
 */

public class FirstBeanDefinitionRegistryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("FirstBeanDefinitionRegistryPostProcessor: postProcessBeanFactory 运行了");
	}
}
