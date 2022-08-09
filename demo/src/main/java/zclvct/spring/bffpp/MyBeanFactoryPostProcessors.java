package zclvct.spring.bffpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/4 21:31
 */
@Component
public class MyBeanFactoryPostProcessors implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition daoServiceImpl = beanFactory.getBeanDefinition("daoServiceImpl");
		daoServiceImpl.setLazyInit(false);
		System.out.printf("daoServiceImpl" + daoServiceImpl.getBeanClassName());
	}
}
