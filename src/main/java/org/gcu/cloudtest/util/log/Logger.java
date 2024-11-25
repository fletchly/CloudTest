package org.gcu.cloudtest.util.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class Logger
{
    private final ObjectMapper objectMapper;

    @Pointcut("within(org.gcu.cloudtest..*)")
    public void baseMonitoringPointcut() {}

    @Before("baseMonitoringPointcut()")
    public void before(JoinPoint joinPoint)
    {
        Date date = new Date();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String args = Arrays.toString(joinPoint.getArgs());

        try
        {
            args = objectMapper.writeValueAsString(joinPoint.getArgs());
        }
        catch (JsonProcessingException e)
        {
            log.trace("Cannot convert argument(s) to JSON: {}", args);
        }

        log.trace("[{}] --> {}.{}() arguments: {}", date, className, methodName, args);
    }

    @AfterReturning(pointcut = "baseMonitoringPointcut()", returning = "returnValue")
    public void afterReturning(JoinPoint joinPoint, Object returnValue)
    {
        Date date = new Date();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String returnedValue = Arrays.toString(joinPoint.getArgs());

        try
        {
            returnedValue = objectMapper.writeValueAsString(returnValue);
        } catch (JsonProcessingException e)
        {
            log.trace("Cannot convert return value(s) to JSON: {}", returnValue);
        }

        log.trace("[{}] <-- {}.{}() returning: {}", date, className, methodName, returnedValue);
    }
}
