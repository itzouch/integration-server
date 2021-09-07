package com.zouch.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Zouch
 * @date 2021/9/3 下午2:57
 */
@Slf4j
@Component
public class BeanTest implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean, Lifecycle {
    @Override
    public void setBeanName(String s) {
        log.info("BeanNameAware.setBeanName调用");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware.setBeanFactory调用");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware.setApplicationContext调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("InitializingBean.afterPropertiesSet调用");
    }

    @Override
    public void destroy() throws Exception {
        log.info("DisposableBean.destroy调用");
    }


    @PostConstruct
    public void init(){
        log.info(" @PostConstruct");
    }

    @PreDestroy
    public void destory1(){
        log.info(" @PostConstruct");
    }


    @Override
    public void start() {
        log.info("Lifecycle.start");
    }

    @Override
    public void stop() {
        log.info("Lifecycle.stop");
    }

    @Override
    public boolean isRunning() {
        log.info("Lifecycle.running");
        return false;
    }
}
