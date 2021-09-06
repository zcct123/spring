package zclvct.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author zhaochong
 * @version 1.0
 * @description: aopDemo
 * @date 2021/8/6 19:14
 */
@Aspect
@Component
public class TestAop {

	@Pointcut("execution(* zclvct.spring.serviceimpl.UserServiceImpl.*(..))")
	public void pointCut(){}

	@Before("pointCut()")
	public void before(JoinPoint joinPoint)
	{
		Class clz = joinPoint.getTarget().getClass();
		Signature signature = joinPoint.getSignature();
		String name = signature.getName();
		System.out.println("========="+"前置通知:"+name+"===========");
	}
//	@After("zclvct.spring.aop.TestAop.pointCut()")
//	public void after(JoinPoint joinPoint)
//	{
//		Class clz = joinPoint.getTarget().getClass();
//		String name = clz.getName();
//		System.out.println("========="+"后置通知:"+name+"===========");
//	}
//
//	@Around("zclvct.spring.aop.TestAop.pointCut()")
//	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("========="+"环绕前"+"===========");
//		joinPoint.proceed();
//		System.out.println("========="+"环绕后"+"===========");
//
//	}
//
//	@AfterThrowing("zclvct.spring.aop.TestAop.pointCut()")
//	public void afterThrowing(JoinPoint joinPoint) throws Throwable {
//		System.out.println("========="+"异常通知"+"===========");
//
//	}
//	@AfterReturning("zclvct.spring.aop.TestAop.pointCut()")
//	public void afterReturning(JoinPoint joinPoint) throws Throwable {
//		System.out.println("========="+"最终通知"+"===========");
//
//	}
}
