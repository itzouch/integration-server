package com.zouch.test.proxy;

import org.springframework.stereotype.Service;

/**
 * @author ZouQi
 * @date 2021/9/7 上午9:41
 */
@Service
public class IServiceImpl implements IService{
    @Override
    public void method1() {
        System.out.println("方法1");
    }

    @Override
    public void method2() {
        System.out.println("方法2");
    }
}
