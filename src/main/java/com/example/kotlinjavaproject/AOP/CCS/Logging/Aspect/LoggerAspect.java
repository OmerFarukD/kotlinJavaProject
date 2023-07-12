package com.example.kotlinjavaproject.AOP.CCS.Logging.Aspect;

import com.example.kotlinjavaproject.AOP.Aspects.Logging.LogResult;
import com.example.kotlinjavaproject.AOP.CCS.Logging.LogType;
import com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerManager.DatabaseLogger;
import com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerManager.FileLogger;
import com.example.kotlinjavaproject.Core.Results.Result;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {

   private final FileLogger fileLogger;
   private final DatabaseLogger databaseLogger;

    @Pointcut("@annotation(logResult)")
    public void callLogResultMethod(LogResult logResult) {}


    @AfterReturning(value = "callLogResultMethod(logResult)",returning ="result")
    public void logger(ProceedingJoinPoint point,LogResult logResult, Result result) throws Throwable {

        LogType logType = logResult.type();
        switch (logType){
            case DATABASE -> databaseLogger.logToDb(point, result);
            case FILE -> fileLogger.writeLog(point, result);
        }
    }
}
