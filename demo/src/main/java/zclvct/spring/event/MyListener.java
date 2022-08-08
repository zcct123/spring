package zclvct.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2022/8/6 13:18
 */
@Component
public class MyListener implements ApplicationListener<MyApplicationEvent> {
	// 由于监听的是String类型的事件会被封装成PayloadApplicationEvent，所以此处类型是PayloadApplicationEvent
	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		String source = (String)event.getSource();
		System.out.printf("监听者收到了消息" + source);
	}
}
