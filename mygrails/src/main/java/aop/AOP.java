package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class AOP {
    @Before("within(mygrails..*)")
    public void logBefore(JoinPoint joinPoint) {
        String logMessage = String.format("Hitting method execution: %s.%s(%s)",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
        System.out.println(logMessage);
    }
}
