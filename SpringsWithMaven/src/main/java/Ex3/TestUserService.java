package Ex3;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
package: Ex3

Need:
1.User.java   -> Pojo class
2.UserService.java  -> Service/Bean class
3.TestUserService.java
4.springs.xml


Spring create and manage obj for UserService  [ Bean]
Dev create obj and populate data  for User [POJO]

Req:
	Dev has to register UserService.java in springs.xml
	spring has to create oj for UserService
  	Dev has to create obj for User and set the data
	dev has to call the saveUser() method on UserService


 */
public class TestUserService {

	public static void main(String[] args) {
		// get input from console
		System.out.println("enter user detials::");
		Scanner sc = new Scanner(System.in);

		System.out.println("enter name");
		String name = sc.next();

		System.out.println("enter mobile");
		String mobile = sc.next();

		System.out.println("enter gender");
		String gender = sc.next();

		// keep input data in user obje
		User user = new User(name, mobile, gender);
		
		// get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex3/springs.xml");

		// get user service obj with the help of context obj
		UserService us = (UserService) context.getBean("userServiceObj");

		// save obj data
		us.saveUser(user);

	}
}
