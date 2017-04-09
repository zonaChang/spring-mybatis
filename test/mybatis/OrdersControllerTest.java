package mybatis;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.changez.sm.base.bean.Orders;
import com.changez.sm.controller.OrdersController;
import com.changez.sm.controller.UserController;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:43:41
 */
public class OrdersControllerTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
	@Test
	public void modify(){
		int a = 0;
		System.out.println(a+"workspace change place 1, user controller");
	}
	@Test
	public void testGetUserById() {
		OrdersController ordersController = (OrdersController) applicationContext.getBean("ordersController");
//		System.out.println(ordersController.queryOrderAndUser());
		List<Orders> list = ordersController.queryOrderAndDetail();
		System.out.println(list);
	}
	@Test
	public void update(){
		int a = 0;
		System.out.println(a+"workspace change place 2, user controller");
	}	
	@Test
	public void lazyLoading() {
		OrdersController ordersController = (OrdersController) applicationContext.getBean("ordersController");
		Orders a = ordersController.queryOrderAndUserLoading();
		System.out.println(a.getId()+",  "+a.getOrderNum());
		
		System.out.println(000000);
		System.out.println(a.getUser().getUsername()+",  "+a.getUser().getSex());
		System.out.println(1111);
	}
}
