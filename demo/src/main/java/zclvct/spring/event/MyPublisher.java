package zclvct.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 13:15
 */
@Component
public class MyPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void doPublisher(String msg){
		applicationEventPublisher.publishEvent(new MyApplicationEvent(msg));
	}
}
