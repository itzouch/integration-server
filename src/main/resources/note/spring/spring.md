实例化：分配内存
属性填充：设值
初始化：执行bean相关的后置处理器等方法

1. 面试官：Spring是如何解决的循环依赖？
答：Spring通过三级缓存解决了循环依赖，其中一级缓存为单例池（singletonObjects）,二级缓存为早期曝光对象earlySingletonObjects，三级缓存为
早期曝光对象工厂（singletonFactories）。当A、B两个类发生循环引用时，在A完成实例化后，就使用实例化后的对象去创建一个对象工厂，并添加到三级缓
存中，如果A被AOP代理，那么通过这个工厂获取到的就是A代理后的对象，如果A没有被AOP代理，那么这个工厂获取到的就是A实例化的对象。当A进行属性注入时
，会去创建B，同时B又依赖了A，所以创建B的同时又会去调用getBean(a)来获取需要的依赖，此时的getBean(a)会从缓存中获取，第一步，先获取到三级缓存
中的工厂；第二步，调用对象工工厂的getObject方法来获取到对应的对象，得到这个对象后将其注入到B中。紧接着B会走完它的生命周期流程，包括初始化、
后置处理器等。当B创建完后，会将B再注入到A中，此时A再完成它的整个生命周期。至此，循环依赖结束！
    1. 二级缓存也可以解决循环依赖，为什么要用三级缓存？
    如果使用二级缓存解决循环依赖，意味着所有 Bean 在实例化后就要完成 AOP 代理，这样违背了 Spring 设计的原则，Spring 在设计之初就是通过
    AnnotationAwareAspectJAutoProxyCreator 这个后置处理器来在 Bean 生命周期的最后一步来完成 AOP 代理，而不是在实例化后就立马进行 AOP 代理。

2、 bean的生命周期
    1. 实例化
    2. 创建对象工厂 放入到三级缓存singletonFactories中
    2. 属性填充 populateBean
    3. 初始化之前 BeanNameAware、BeanFactoryAware、ApplicationContextAware、InitializationBean、BeanPostProcessor
    4. 初始化 @PostConstruct修饰方法
    5. 初始化后 BeanPostProcessor
    6. 销毁 @Destroy

3、哪里用到了设计模式?
    1. 工厂设计模式：BeanFactory创建对象，ApplicationContext创建对象..
    2. 代理模式：AOP功能的时间
    3. 单例模式：bean
    4. 模板方法：jdbcTemplate
    5. 观察者模式：Spring的事件驱动模型
    6. 适配器模式：Spring AOP 的增强或通知 (Advice) 使用到了适配器模式、spring MVC 中也是用到了适配器模式适配 Controller。
4. 事务
    1. 声明式事务
    2. 编程式事务

   事务传播机制实际上是使用简单的 ThreadLocal 实现的，所以，如果调用的方法是在新线程调用的，事务传播实际上是会失效的。

5.
