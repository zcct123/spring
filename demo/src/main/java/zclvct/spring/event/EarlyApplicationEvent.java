package zclvct.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 14:25
 */
@Component
public class EarlyApplicationEvent extends ApplicationEvent {

	public EarlyApplicationEvent(Object source) {
		super(source);
	}

}
