package aop.beforeAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public  class BeforeMethodImpl implements 
MethodBeforeAdvice{

	public void before(Method methodInvocation, Object[] arg1, Object arg2)
			throws Throwable {
			System.out.println("sfsfsfsf");	
			Object result = methodInvocation.invoke(arg1, arg2);
	}

}
