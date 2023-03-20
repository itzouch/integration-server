阻塞队列：提供特定的put和take方法，
当队列满了后，put方法就会阻塞当前线程；
当队列为空时，take方法就会阻塞当前线程。

1.ArrayBlockingQueue 底层存储数组结构，需要提前声明存储大小
2.LinkedBlockingQueue 底层链表存储结构，默认大小Integer.MaxValue(),也叫无界队列。
其他队列个人感觉不常用，大多数的场景都会被消息队列组件替代。