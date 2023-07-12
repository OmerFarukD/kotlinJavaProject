package com.example.kotlinjavaproject.AOP.CCS.Logging.LoggerManager;

import com.example.kotlinjavaproject.AOP.CCS.Logging.LogDetails;
import com.example.kotlinjavaproject.AOP.CCS.Logging.LogStatus;
import com.example.kotlinjavaproject.Core.Exceptions.BusinessException;
import com.example.kotlinjavaproject.Core.Results.Result;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Field;
import java.util.Date;

public interface BaseLogger {

   default LogDetails writeLog(ProceedingJoinPoint point, Result result) throws Throwable{
       String methodName = point.getSignature().getName();
       Object[] args = point.getArgs();
       String params = "";
       if (args.length>0){
           StringBuilder paramsBuilder = new StringBuilder();
           for (Object arg : args){
               paramsBuilder.append(arg.getClass().getSimpleName())
                       .append(":{");

               Field[] fields = arg.getClass().getDeclaredFields();
               for (Field field : fields) {
                   field.setAccessible(true);

                   try{
                       paramsBuilder.append(field.getName())
                               .append(":")
                               .append(field.get(arg).toString())
                               .append(", ");
                   }catch (IllegalAccessException e){
                       throw new BusinessException(e.getMessage());
                   }
               }
               paramsBuilder.setLength(paramsBuilder.length()-2);
               paramsBuilder.append("}, ");
           }
           paramsBuilder.setLength(paramsBuilder.length()-2);
           params=paramsBuilder.toString();
       }
       LogDetails logDetails = new LogDetails();
       logDetails.setMethodName(methodName);
       logDetails.setParameters(params);
       logDetails.setLogDate(new Date());
       logDetails.setReturnValue(result.getMessage());

       if (result.isSuccess()) logDetails.logStatus= LogStatus.INFO;
       else logDetails.logStatus=LogStatus.ERROR;

       return logDetails;
   }
}
