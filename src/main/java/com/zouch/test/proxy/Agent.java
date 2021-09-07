package com.zouch.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZouQi
 * @date 2021/9/7 上午9:36
 * 步骤
 * 1.创建要代理类 实现InvocationHandler接口
 * 2.invoke方法实现被代理类方法的调用和自定义的逻辑处理
 * 3.通过Proxy.newProxyInstance方法生成代理对象实例
 */
public class Agent implements InvocationHandler {
//    public void proxy(){
//        InvocationHandler invocationHandler = (proxy, method, args) -> {
//            System.out.println("被调用的方法是：" + method.getName());
//
//            method.invoke(method, (Object) null);
//            return null;
//        };
//        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
//        proxyService.method1();
//    }

//    public static void main(String[] args) {
//        Agent agent = new Agent();
//        agent.proxy();
//    }

    private Object target;

    public Agent(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long startTime = System.currentTimeMillis();
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));

        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Object target, Class<T> targetInterface) {
        if (!targetInterface.isInterface()) {
            throw new IllegalStateException("targetInterface必须是接口类型!");
        }
        if (!targetInterface.isAssignableFrom(target.getClass())) {
            throw new IllegalStateException("target必须是targetInterface的实现类!");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new Agent(target));
    }

    public static void main(String[] args) {
        IService proxy = Agent.createProxy(new IServiceImpl(), IService.class);
        proxy.method1();
    }


}
