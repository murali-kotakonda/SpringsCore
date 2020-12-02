package Ex5constrInject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
Req:
AccountService has dbName as dependency
UserService has "userName" and "accountService" obj as dependency.

UserService                                                  AccountService
------------------------------------------------------------------------------------------------
AccountService accountService;
saveUser(){																										

	accountService.save(); --------------------------------->		save(){
																   }
    																															}
}

 */
public class TestUser {

	public static void main(String[] args) {
		//get context obj
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/java/Ex5constrInject/springs.xml");
		
		//get UserService obj from springs
		UserService service = (UserService)	context.getBean("uService");
		service.saveUser();
	}

}
