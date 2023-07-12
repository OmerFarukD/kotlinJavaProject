package com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerManager;

import com.example.kotlinjavaproject.AOP.CCS.Logging.LogDetails;
import com.example.kotlinjavaproject.Core.Results.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Component
public class FileLogger implements BaseLogger{

    private final ObjectMapper objectMapper;

    public FileLogger(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private final String fileName="logs/myapp.log";

    public void logToFile(ProceedingJoinPoint point, Result result) throws Throwable {

        LogDetails logDetails =writeLog(point,result);
        String logMessage = objectMapper.writeValueAsString(logDetails);
        Files.write(Paths.get(fileName),logMessage.getBytes(), StandardOpenOption.APPEND);

    }
}
