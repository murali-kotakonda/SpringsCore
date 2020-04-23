package annotations.autowireQualifierOLD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
 
 
public class TestLoginDAO {
 
    public static void main(String args[]) {
        AbstractApplicationContext context =
        		new AnnotationConfigApplicationContext(
        		ApplicationConfig.class);
        LoginDAO loginDao = (LoginDAO)context.getBean("loginDAO");
        LoginDAO loginDao1 = (LoginDAO)context.getBean(LoginDAO.class);
        loginDao.save();
    }
 
}