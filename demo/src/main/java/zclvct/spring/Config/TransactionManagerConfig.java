package zclvct.spring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 22:25
 */
@Configuration
public class TransactionManagerConfig {

	@Bean
	public JdbcTransactionManager jdbcTransactionManager (DataSource dataSource){
		return  new JdbcTransactionManager(dataSource);
	}
}
