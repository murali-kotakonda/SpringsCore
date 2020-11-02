package Ex91_IssueConstrInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
Assignment:
------------------
package : issue
The classes in the package were resolved without using springs.
Resolve the dependencies using springs with constr injection

---------------
For Controller class, service obj is the dependency.
For Service class, Helper obj is the dependency.
For Helper class, Dao obj is the dependency.
 */
public class TestDI {
	
	public static void main(String[] args) {
		//get context obj
		ApplicationContext context =new ClassPathXmlApplicationContext("file:src/main/java/Ex9constrInjectMap/springs.xml");
		
	}
}