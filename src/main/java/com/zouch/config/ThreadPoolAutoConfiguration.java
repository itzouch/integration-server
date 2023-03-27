package com.zouch.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import reactor.core.Disposable;

/**
 * @author: Zouch
 * @date: 2021-12-03 15:40
 */
@Configuration
public class ThreadPoolAutoConfiguration {

    @Qualifier
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutorConfig(){
        ThreadPoolTaskExecutor corePoll = new ThreadPoolTaskExecutor();
        corePoll.setCorePoolSize(10);
        corePoll.setMaxPoolSize(20);
        corePoll.setKeepAliveSeconds(60);
        corePoll.setQueueCapacity(500);
        corePoll.setThreadNamePrefix("core-");
        corePoll.initialize();
        return corePoll;
    }


}
