package annotations.ex1OLD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext();

		ctx.register(ServiceConfig.class);
		ctx.refresh();

		MyService myService = ctx.getBean(MyService.class);
		MyService myService1 = ctx.getBean(MyService.class);
		System.out.println(myService.getMsg());
	}
}
