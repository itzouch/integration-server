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
    - Hashtable
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
    
    
