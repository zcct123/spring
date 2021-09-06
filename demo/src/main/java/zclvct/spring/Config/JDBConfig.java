package zclvct.spring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 21:46
 */
@Configuration
public class JDBConfig {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return  jdbcTemplate;
	}
}
