package annotations.ex2OLD;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext();

		ctx.register(ServiceConfig.class);
		ctx.refresh();

		Service myService = ctx.getBean(Service.class);
		Service myService1 = ctx.getBean(Service.class);
		myService.getMessage();
		myService.process();
	}
}
