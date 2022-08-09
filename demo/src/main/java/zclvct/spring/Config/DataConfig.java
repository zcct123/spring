package zclvct.spring.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zcct
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 21:47
 */
@Configuration
public class DataConfig {

	@Bean
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("zclvct");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cachedb?useSSl=ture&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
		try {
			Connection	connection = dataSource.getConnection();
		} catch (SQLException throwables) {
			System.out.println("数据库链接失败"+throwables.getMessage());
		}
		return dataSource;
	}
}
