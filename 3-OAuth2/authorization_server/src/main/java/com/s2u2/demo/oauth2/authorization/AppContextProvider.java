package com.s2u2.demo.oauth2.authorization;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AppContextProvider implements ApplicationContextAware {

    private static ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppContextProvider.appContext = applicationContext;
    }

    public static ApplicationContext getContext() {
        return AppContextProvider.appContext;
    }
}
