package com.example.kotlinjavaproject.AOP.Aspects.Logging;

import com.example.kotlinjavaproject.AOP.CCS.Logging.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface LogResult {
    LogType type() default LogType.DATABASE;
}
