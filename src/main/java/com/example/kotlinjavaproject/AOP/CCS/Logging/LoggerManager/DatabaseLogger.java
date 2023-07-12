package com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerManager;

import com.example.kotlinjavaproject.AOP.CCS.Logging.LogDetails;
import com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerRepository;
import com.example.kotlinjavaproject.Core.Results.Result;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DatabaseLogger implements BaseLogger {

    private final LoggerRepository loggerRepository;

    public void logToDb (ProceedingJoinPoint point, Result result) throws Throwable {
        LogDetails logDetails = writeLog(point,result);
        this.loggerRepository.save(logDetails);

    }
}
