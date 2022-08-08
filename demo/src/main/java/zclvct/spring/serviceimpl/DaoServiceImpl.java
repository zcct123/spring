package zclvct.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import zclvct.spring.service.DaoService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 22:07
 */
@Repository
public class DaoServiceImpl  implements DaoService {

	@Value("${server.address }")
	private String address;

	@Value("${server.port }")
	private String port;

	//@Resource
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	DaoService daoService;

	@Override
	@Transactional
	public Map<String, Object> select(Integer id) {
		String sql = "select * from sys_user where id = ? ;";
		Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, id);
		System.out.println(sql);
		System.out.println("param:"+id);
		return  stringObjectMap;
	}

	@Override
	public void update(Integer id) {
		String sql ="UPDATE `cachedb`.`sys_user` SET " +
				"`employee_name` = '张三', `name` = '2020003:张三'," +
				" `password` = 'e10adc3949ba59abbe56e057f20f883e', " +
				"`tenant_id` = 4, `role_id` = 20, `create_date` = '2020-01-16 22:50:48'," +
				" `is_delete` = 1, `phone` = NULL, `email` = NULL WHERE `id` = ?;";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from sys_user where id =?";
		//jdbcTemplate.(sql,id);
	}

	@Override
	@Transactional
	public void insert () {
		String sql = "INSERT INTO `cachedb`.`sys_user`( `employee_name`, `name`, `password`, `tenant_id`, `role_id`, `create_date`, `is_delete`, `phone`, `email`) " +
				"VALUES ('张三测试', '2020003:张三', 'e10adc3949ba59abbe56e057f20f883e', 4, 20, '2020-01-16 22:50:48', 1, NULL, NULL);";
		jdbcTemplate.execute(sql);

		//test();   // 执行的是 被代理 对象的test方法  因为他没有被代理 所以@Transactional(propagation = Propagation.NEVER) 不生效
//		daoService.test(); // 使用代理对象执行 则会  Propagation.NEVER 报错
	}

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void test(){
		update(39);
		//insert();
	}
}
