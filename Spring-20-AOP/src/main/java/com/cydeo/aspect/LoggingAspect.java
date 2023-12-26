package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    //We will build all Logging perspective business logic here for the application
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    private void pointcut(){

    }


    @Before("pointcut()")
    public void log(){
        logger.info("Logger info --------------");
    }


    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info --------------");
    }



    @Pointcut("execution(* com.cydeo.*.CourseRepository.findById(*))")
    private void anyProductRepositoryFindById(){

    }

    @Before("anyProductRepositoryFindById()")
    public void beforeCourseRepoOperation(JoinPoint joinPoint){
        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }


    //within
    @Pointcut("within(com.cydeo.controller..*)")
    private void anyControllerOperation(){

    }

    //it will help class level information
    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceOperation(){

    }


    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before () -> Method : {} - Arguments : {} - Target : {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteCourseOperation(){

    }

    @Before("anyDeleteCourseOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",
                joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }
    */

    /**
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){

    }

    @AfterReturning(pointcut ="anyGetCourseOperation()", returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object results){

        logger.info("After returning - > Method: {} - results: {}",
                joinPoint.getSignature().toShortString(), results.toString());
    }

    @AfterReturning(pointcut ="anyGetCourseOperation()", returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> results){

        logger.info("After returning(List) - > Method: {} - results: {}",
                joinPoint.getSignature().toShortString(), results.toString());
    }


    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
        logger.info("After Throwing - > Method: {} - Exception: {}",
                joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @After("anyGetCourseOperation()")
    public void afterControllerAdvice(JoinPoint joinPoint){
        logger.info("After finally - > Method: {}",
                joinPoint.getSignature().toShortString());
    }
    */



}
