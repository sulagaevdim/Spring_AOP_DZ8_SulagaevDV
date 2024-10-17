package ru.geekbrains.spring_aop_dz8_sulagaevdv.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class UserActionLogger {
    private static final Logger logger = Logger.getLogger(UserActionLogger.class.getName());
    @Before("@annotation(*ru.geekbrains.spring_aop_dz8_sulagaevdv.TrackUserAction)")
    @Order(1)
    public void beforeLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = signature.getDeclaringTypeName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method called: " + className + methodName + " with arguments " + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "@annotation(*ru.geekbrains.spring_aop_dz8_sulagaevdv.TrackUserAction)", returning = "result")
    @Order(2)
    public void afterLog(JoinPoint joinPoint, Object result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        String className = signature.getDeclaringTypeName();

        logger.info("Method finished: "+ className + methodName + " with result " + result);
    }
}
