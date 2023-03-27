package com.zouch.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author ZouQi
 * @date 2023/3/16 15:09
 */
public class ApplicationEndUp implements DisposableBean {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    /**
     * 应用关闭后可以做的一些操作
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        executor.destroy();
    }
}
