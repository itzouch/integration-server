question: 为什么数组查询复杂度为O（1）
    a:数组内存地址是连续的,根据索引查询时，无须比较，因为物理地址的单位长度是相同的。
# 数据结构
1. sds
    简单动态字符串
    优点是获取字符串长度时间复杂度为O1。
    不一定每次更改字符串长度都会内存重分配，因为有部分预分配。
    兼容部分c库函数。
    
2. inset
    整数集合
    
3. dict
    字典
    哈希表，和hashmap类似。但是内部有两个数组，h[0]和h[1],一个用来存放当前数据,一个用来rehash。类似于堆中的to和from。
    rehash时采用渐进式hash，不会一次性执行完，在执行途中两个数组共享数据。执行结束重新分配空数组用于下次执行。

4. zipList
    压缩列表

5. skipList
    跳跃表（链表+多级索引）
    以空间换时间的方式提高查找速度。
    和平衡树相比，范围查找优。
    
    
# 对象编码
# 记忆方法 string和set不包括ZipList set利用dic去重 hash用hashtable list用LinkedList有序 zSet利用跳表增加查找速度，利用dict去重
1. zset 
    特点：k-v-score 有序、去重。支持按score排序，支持范围查找。
    - 跳表+dict    
    - ZipList （元素数量<128且每个元素长度小于64byte）
    
2. set  
    特点：k-v 无序、去重。支持求集合间交集、并集、差集。
    编码类型：
    - intSet（元素是整数且数量小于512）
    - dict
3. hash 
    特点：k-k-v 保存用户信息、配置信息等、购物车、计数器。
    编码类型：
    - ZipList（元素数量<512且每个元素长度小于64byte）
    - dict
4. list 
    特点：k-v 有序 消息队列、栈、有序场景。
    编码类型：
    - ZipList（元素数量<512且每个元素长度小于64byte）
    - LinkedList
    - QuickList(zipList+LinkedList)
5. string k-v
    特点：k-v 缓存、分布式id、ip限流
    - int
    - sds
    内部编码：
    - int
    - raw
    - embstr
    
# 内存淘汰策略
1. 直接返回错误
2. 全部的key中随机删除
3. 全部的key中使用LRU算法删除
4. 全部的key中使用LRU算法删除
5. 在设置了过期时间的key中，随机删除
6. 在设置了过期时间的key中，使用LRU算法删除
7. 在设置了过期时间的key中，使用LRU算法删除
8. 在设置了过期时间的key中，选剩余时间最短的删除

# redis的LRU算法是怎么实现的？
redisObject中有个字段unsigned lru:LRU_BITS 保存着当前key的最后一次被访问的时间。
version.1 每次随机取N个key，把空闲时间最大的那个移除。
version.2 redis3.0
        当每一轮移除 key 时，拿到了 N（默认5）个 key 的 idle time，遍历处理这 N 个 key，如果 key 的 idle time 比 pool 里面的 key 的 idle time 还要大，就把它添加到 pool 里面去。
        当 pool 放满之后，每次如果有新的 key 需要放入，需要将 pool 中 idle time 最小的一个 key 移除。这样相当于 pool 里面始终维护着还未被淘汰的 idle time 最大的 16 个 key。
        当我们每轮要淘汰的时候，直接从 pool 里面取出 idle time 最大的 key（只取1个），将之淘汰掉。
        整个流程相当于随机取 5 个 key 放入 pool，然后淘汰 pool 中空闲时间最大的 key，然后再随机取 5 个 key放入 pool，继续淘汰 pool 中空闲时间最大的 key，一直持续下去。
        在进入淘汰前会计算出需要释放的内存大小，然后就一直循环上述流程，直至释放足够的内存。
        pool中插入新key时，释放pool中空闲时间最短的。
        释放pool中的key时，释放pool中空闲时间最长的。
# 如果让你来实现lru？
TreeSet

# redis持久化机制？
1. RDB：类似于MySQL中的binlog，二进制形式压缩存储，保存了了某一时间点的数据集。很适合做备份，但是操作太频繁有性能影响。 但是当设置备份时间后，
这段时间内如果宕机会造成这个时间段的数据丢失。

2. AOF：命令追加来保存，保存到的是linux中的pagecache，然后执行命令去刷盘。刷盘的策略有3种
 - 每个命令都刷
 - 每一秒刷一次，由后台线程负责
 - 不主动刷盘，由操作系统控制
最多会丢1s的数据，AOF文件比RDB文件大

3. RDB+AOF
描述：混合持久化并不是一种全新的持久化方式，而是对已有方式的优化。混合持久化只发生于 AOF 重写过程。使用了混合持久化，重写后的新 AOF 文件前半段是 RDB 格式的全量数据，后半段是 AOF 格式的增量数据。
整体格式为：[RDB file][AOF tail]
开启：混合持久化的配置参数为 aof-use-rdb-preamble，配置为 yes 时开启混合持久化，在 redis 4 刚引入时，默认是关闭混合持久化的，但是在 redis 5 中默认已经打开了。
关闭：使用 aof-use-rdb-preamble no 配置即可关闭混合持久化。
混合持久化本质是通过 AOF 后台重写（bgrewriteaof 命令）完成的，不同的是当开启混合持久化时，fork 出的子进程先将当前全量数据以 RDB 方式写入新的 AOF 文件，然后再将 AOF 重写缓冲区（aof_rewrite_buf_blocks）的增量命令以 AOF 方式写入到文件，写入完成后通知主进程将新的含有 RDB 格式和 AOF 格式的 AOF 文件替换旧的的 AOF 文件。
优点：结合 RDB 和 AOF 的优点, 更快的重写和恢复。
缺点：AOF 文件里面的 RDB 部分不再是 AOF 格式，可读性差。
