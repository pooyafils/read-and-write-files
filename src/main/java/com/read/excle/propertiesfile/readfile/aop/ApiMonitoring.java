package com.read.excle.propertiesfile.readfile.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ApiMonitoring {

    @Before("execution(* com.read.excle.propertiesfile.readfile.contoller.ReadAndWriteExcelFileController.*(..))")
    public void check(JoinPoint joinPoint) {
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg : signatureArgs) {
            System.out.println("Arg: " + signatureArg);

        }
    }



    @Before("execution(* com.read.excle.propertiesfile.readfile.contoller.ReadAndWriteExcelFileController.*(..))")
    public void validateToken(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        System.out.println(token);

    }
}
