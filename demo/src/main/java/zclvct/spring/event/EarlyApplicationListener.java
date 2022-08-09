package zclvct.spring.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 14:25
 */
@Component
public class EarlyApplicationListener implements ApplicationListener<EarlyApplicationEvent> {

	@Override
	public void onApplicationEvent(EarlyApplicationEvent event) {
		System.out.printf(event.getSource().toString());
	}
}
