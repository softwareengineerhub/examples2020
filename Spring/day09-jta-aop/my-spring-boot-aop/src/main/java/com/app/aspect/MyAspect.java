package com.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspect {

    //@Around("execution(* com.app.service.MyCalculatorService.*(..))")
    public Object simpleBeforeAdvice(ProceedingJoinPoint joinPoint){
        try {
            Object[] args = joinPoint.getArgs();
            Object target = joinPoint.getTarget();
            System.out.println("args = " + Arrays.toString(args));
            System.out.println("target=" + target);
            System.out.println("kind=" + joinPoint.getKind());
            Object result = joinPoint.proceed();
            System.out.println("Return to ASPECT");
            return 100;
        }catch (Throwable ex){
            throw new RuntimeException(ex);
        }
    }


  // @Around("execution(* com.app.service.CalculationService.*(..))")
    public Object simpleBeforeAdvice2(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("\t####Aspect. start: simpleBeforeAdvice");
            System.out.println("\t####joinPoint.getSignature().getDeclaringTypeName()=" + joinPoint.getSignature().getDeclaringTypeName());
            System.out.println("\t####joinPoint.getSignature().getName()=" + joinPoint.getSignature().getName());
            Object[] args = joinPoint.getArgs();
            System.out.println("\t####method args:"+ Arrays.toString(args));
            /*if("subtract".equals(joinPoint.getSignature().getName())){
                for(Object item: args){
                    Integer i = (Integer) item;
                    if(i<0){
                        //return 1000;
                       // throw  new IllegalArgumentException("negative args");
                    }
                }
            }*/

            /*args[0] = 1000;
            args[1] = 5;
            System.out.println("\t####method changed args:"+ Arrays.toString(args));
            Class cl = Class.forName(joinPoint.getSignature().getDeclaringTypeName());
            Object obj = cl.newInstance();
            Method m = cl.getDeclaredMethod(joinPoint.getSignature().getName(), int.class, int.class);
            Object result = m.invoke(obj, args);
            if(result!=null){
                return result;
            }*/


            Object object = joinPoint.proceed();
            System.out.println("\t####aspect get result: "+object);
            System.out.println("\t####Aspect. end: simpleBeforeAdvice");
            return object;
        }catch(Throwable ex){
            throw new RuntimeException(ex);
        }
    }


}
