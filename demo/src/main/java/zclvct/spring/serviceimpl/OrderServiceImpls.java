package zclvct.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zclvct.spring.service.DaoService;
import zclvct.spring.service.OrderService;

import javax.annotation.Resource;

/**
 * @author zhaochong
 * @version 1.0
 * @description: TODO
 * @date 2021/8/7 16:42
 */
@Service
public class OrderServiceImpls implements OrderService {
	@Resource
	DaoService daoService;
	@Override
	public void test() {

	}
}
