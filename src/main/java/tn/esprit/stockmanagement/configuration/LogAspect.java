package tn.esprit.stockmanagement.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 21/12/2021
 * @project IntelliJ IDEA
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Before("execution(* tn.esprit.stockmanagement.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Executing method " + name + " : ");
    }

    @After("execution(* tn.esprit.stockmanagement.service.*.*(..))")
    public void logAfter(JoinPoint point) {
        log.info("The method "+point.getSignature().getName() + " is called ...");
    }

    @Around("execution(* tn.esprit.stockmanagement.service.FactureServiceImpl.addFacture(..))")
    public void logAroundAddFacture(ProceedingJoinPoint joinPoint) throws Throwable
    {
        log.info("Before Method Execution: "+ joinPoint.getSignature().getName());
        try {
            joinPoint.proceed();
        } finally {

        }
        log.info("After Method Execution: "+ joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(* tn.esprit.stockmanagement.service.*.*(..))",
            returning = "retVal")
    public void afterReturningAdvice(JoinPoint jp, Object retVal){
        log.info("Method : "  + jp.getSignature().getName()+" Returning: " + retVal.getClass().getSimpleName());
        }
}
