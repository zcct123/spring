package zclvct.spring.service;

import java.util.Map;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 22:04
 */

public interface DaoService {
	Map<String, Object> select(Integer id);
	void update(Integer id);
	void delete(Integer id);
	void insert ();
	void test();
}
