package serviceimpl;

import org.springframework.stereotype.Service;
import service.UserService;

/**
 * @description:
 * @projectName:spring
 * @see:serviceimpl
 * @author:赵冲
 * @createTime:2021/8/3 12:24
 * @version:1.0
 */
@Service
public class UserServiceImpl implements UserService {
	@Override
	public void test() {
		System.out.println("我是userserviceTest01");
	}
}
