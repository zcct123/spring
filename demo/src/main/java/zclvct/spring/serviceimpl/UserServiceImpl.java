package zclvct.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zclvct.spring.service.OrderService;
import zclvct.spring.service.UserService;

import javax.annotation.Resource;

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

	//  Autowired  Resource
//
	@Autowired   // 由Spring提供，byType注入
	@Qualifier("orderQualifier")
	private OrderService orderService2;

//	@Autowired
//	private OrderServiceImpls orderServiceImpls;


//	@Resource  //由J2EE提供，默认按照byName自动注入     动态代理之后不能使用子类注入因为类型不统一
//	private OrderServiceImpls orderServiceImpls;


	/**
	 * spring 推断构造方法
	 * 	默认使用无参够高方法
	 * 	如果只有一个有参的构造方法 则使用
	 * 	如果有不止一个有参构造方法则报错 不知道选择哪一个构造方法
	 * 	可以指定哪一个构造  使用@AutoWired注解
	 */

	public UserServiceImpl() {
		System.out.println("无参构造方法实例化");
	}

//	public UserServiceImpl(OrderService orderService) {
//		System.out.println("单个参构造方法实例化");
//		this.orderService = orderService;
//	}
	@Autowired										  // 这里初始化会使用ioc容器中学找bean  先bytype  如果找到多个bean 使用byname  是在单例缓冲池中
	public UserServiceImpl(OrderService orderService2 , OrderServiceImpl orderServiceImpl) {
		System.out.println("两个参构造方法实例化");
	}


	@Override
	public void test() {
		System.out.println("我是userserviceTest01");
	//	orderService.test();
	}
}
