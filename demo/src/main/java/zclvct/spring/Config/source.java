package zclvct.spring.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2022/8/7 13:43
 */
@Component
@PropertySource(value={"classpath:application.properties"})
public class source {
	@Value("${server.address }")
	private String address;

	@Value("${server.port }")
	private String port;
}
