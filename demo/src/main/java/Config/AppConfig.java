package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.UserService;
import serviceimpl.UserServiceImpl;

/**
 * @description:
 * @projectName:spring
 * @see:Config
 * @author:赵冲
 * @createTime:2021/8/3 12:24
 * @version:1.0
 */
@Configuration
public class AppConfig {
	@Bean
	public UserService userService (){
		return  new UserServiceImpl();
	}
}
