package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    //@Pointcut : 여러 조인포인트를 매치하기 위해 지정한 표현식
    // execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    // 수식어 생략 가능 (public, private, protected, default)
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    // @Before : 리턴 타입은 void로 해야하고 매개변수는 JoinPoint joinPoint로 들어가야한다. 다른게 들어가도 JoinPoint joinPoint가 첫번째에 있어야한다.
    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) {
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // pointcut = <-- 속성이라 기입 안해도 되지만 여러가지 속성 정의시 기입해야함.
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning result : "  + result);
        
        if(result != null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }

    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("AfterThrowing exception : "  + exception);
    }

    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        // 사전
        System.out.println("Around Before : " + joinPoint.getSignature().getName());

        // 원본 조인 포인트를 실행한다.
        Object result = joinPoint.proceed();

        // 사후
        System.out.println("Around After : : " + joinPoint.getSignature().getName());

        return result;
    }
}
