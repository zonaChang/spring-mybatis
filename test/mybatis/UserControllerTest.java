package mybatis;

import org.codehaus.jackson.map.Module.SetupContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.changez.sm.base.bean.User;
import com.changez.sm.controller.UserController;

/**
 * @desc: 
 * @auth: zona
 * 2017年2月6日 下午5:43:41
 */
public class UserControllerTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setup() {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

	}

	@Test
	public void testGetUserById() {
		UserController userController = (UserController) applicationContext.getBean("userController");
		System.out.println(userController.getUserById("1"));;
//		System.out.println(userController.getAllUser());
	}

	@Test
	public void modify(){
		int a = 0;
		System.out.println(a+"workspace change place 1, user controller");
	}

	@Test
	public void queryUserAndItems() {
		UserController userController = (UserController) applicationContext.getBean("userController");
		User a = userController.queryUserAndItems();
		System.out.println(a);
	}
	
	@Test
	public void update(){
		int a = 0;
		System.out.println(a+"workspace change place 2, user controller");
	}
	@Test
	public void addUser() {
		UserController userController = (UserController) applicationContext.getBean("userController");
		User user = new User();
		user.setUsername("changez2");
		userController.addUser(user);
	}
}
