package com.test.aop;


import com.test.to.ServiceResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author feifan.han
 * @date 2020/12/11 11:15 PM
 */
@Component
@Aspect
@Slf4j
public class ErrorCatchAdvice {
    @Around(value = "@annotation(com.test.aop.annotation.ErrorCatch)")
    public Object handlerRpcResult(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Exception e) {
            log.error("{} error, args {}", point.getSignature().getName(), point.getArgs(), e);
            return ServiceResult.buildFail("系统异常");
        }
    }
}    