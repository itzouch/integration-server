# 线程池-完结
1. 线程池的作用？
    1. 节约资源
    2. 便于管理
    3. 提高响应速度

2. 线程池的核心参数？
    1. corePoolSize
    2. maxPoolSize
    3. workQueue
    4. handler
    5. threadFactory
    6. keepAliveTime

3. 线程池的运行原理
    1. 任务提交到线程池，判断当前存活线程是否达到核心线程数
    2. 未达到则新建一个线程，达到则判断阻塞队列是否已满，未满则加入阻塞队列。
    3. 阻塞队列已满，判断当前活跃线程是否达到最大线程数，没达到则新建一个线程。
    4. 达到则执行handler拒绝策略。

4. 阻塞队列
    1. ArrayBlockingQueue:有界
    2. LinkedBlockingQueue：有界/无界
    3. SynchronousQueue：将一个元素放入 SynchronousQueue 中，必须有另一个线程正在等待接受这个元素。
    如果没有线程等待，并且线程池的当前大小小于最大值，那么线程池将创建一个线程，否则根据拒绝策略，这个任务将被拒绝。
    使用直接移交将更高效，因为任务会直接移交给执行它的线程，而不是被放在队列中，然后由工作线程从队列中提取任务。
    只有当线程池是无界的或者可以拒绝任务时，该队列才有实际价值。Executors.newCachedThreadPool使用了该队列。
    4. PriorityBlockingQueue:无界，优先级通过自然序或者Comparator来定义。

5. 拒绝策略
    1. AbortPolicy：直接终止，抛出异常。默认的策略。
    2. DiscardPolicy：直接丢弃。
    3. DiscardOldestPolicy：抛弃最老策略。抛弃阻塞队列中最老的任务，相当于就是队列中下一个将要被执行的任务，然后重新提交被拒绝的任务。
    如果阻塞队列是一个优先队列，那么“抛弃最旧的”策略将导致抛弃优先级最高的任务，因此最好不要将该策略和优先级队列放在一起使用。
    4. CallerRunsPolicy：由调用者自身处理。

6. 简单理解ThreadPoolTaskExecutor和ThreadPoolExecutor的区别
   1. ThreadPoolTaskExecutor使用ThreadPoolExecutor并增强，扩展了更多特性
   2. ThreadPoolTaskExecutor只关注自己增强的部分，任务执行还是ThreadPoolExecutor处理。
   3. 前者spring自己用着爽，后者离开spring我们用ThreadPoolExecutor爽。
   注意：ThreadPoolTaskExecutor 不会自动创建ThreadPoolExecutor需要手动调initialize才会创建
       如果@Bean 就不需手动，会自动InitializingBean的afterPropertiesSet来调initialize

7. 线程池数量怎么设置？
    1. CPU密集型，CPU数+1
    2. IO密集型，经验值 2*CPU数，最佳线程数目 = （（线程等待时间+线程CPU时间）/线程CPU时间 ）* CPU数目
