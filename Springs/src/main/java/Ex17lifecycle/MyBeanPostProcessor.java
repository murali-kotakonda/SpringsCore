package Ex17lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object obj, String beanId) throws BeansException {
		System.out.println("Inside postProcessAfterInitialization method for-" + beanId);
		return obj;
	}

	public Object postProcessBeforeInitialization(Object obj, String beanId) throws BeansException {
		System.out.println("Inside postProcessBeforeInitialization for-" + beanId);
		return obj;
	}
}
