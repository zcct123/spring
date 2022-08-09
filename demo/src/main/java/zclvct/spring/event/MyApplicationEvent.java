package zclvct.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 12:56
 */
public class MyApplicationEvent extends ApplicationEvent {


	public MyApplicationEvent(Object source) {
		super(source);
	}
}
