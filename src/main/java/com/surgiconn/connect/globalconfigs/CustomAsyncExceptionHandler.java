package com.surgiconn.connect.globalconfigs;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(
            Throwable throwable, Method method, Object... obj) {

        Logger.getLogger(CustomAsyncExceptionHandler.class.getName()).log(Level.SEVERE, null, throwable);

        for (Object param : obj) {
            Logger.getLogger(CustomAsyncExceptionHandler.class.getName()).log(Level.SEVERE, null, param);
        }
    }

}
