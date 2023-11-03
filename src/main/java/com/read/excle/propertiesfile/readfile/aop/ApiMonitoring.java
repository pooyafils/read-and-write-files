package com.read.excle.propertiesfile.readfile.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ApiMonitoring {

    @Before("execution(* com.read.excle.propertiesfile.readfile.contoller.ReadAndWriteExcelFileController.*(..))")
    public void check(JoinPoint joinPoint){
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            System.out.println("Arg: " + signatureArg);

        }
    }
}
