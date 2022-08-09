//package zclvct.spring.bffpp;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanDefinition;
//import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
//import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.stereotype.Component;
//import zclvct.spring.event.EarlyApplicationEvent;
//
///**
// * @author zcct
// * @version 1.0
// * @description: TODO
// * @date 2022/8/4 21:31
// */
//@Component
//public class EarlyEventBeanFactoryPostProcessors implements BeanFactoryPostProcessor {
//
//	@Override
//	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//		EarlyApplicationEvent earlyApplicationEvent = (EarlyApplicationEvent)beanFactory.getBean("earlyApplicationEvent");
//		if(beanFactory instanceof AbstractApplicationContext) {
//			((AbstractApplicationContext) beanFactory).publishEvent(earlyApplicationEvent);
//		}
//	}
//}
