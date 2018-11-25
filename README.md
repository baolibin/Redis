### Redis相关知识点学习整理

+ Redis数据类型主要有String、Hash、List、Set、SortedSet
+ Redis配置文件redis.conf
+ Redis支持部分事务
+ Redis持久化方法有RDB和AOF
+ Redis发布订阅
+ Redis主从复制
+ Redis的Java客户端Jedis

---
##### 1.常用的Nosql数据库有哪些？
    Redis、memcache、Mongodb
##### 2.Redis常用数据类型都有哪些？
    String(字符串)、Hash(哈希)、List(列表)、Set(集合)、SortedSet(有序集合)
##### 3.如何查看和设置key的ttl?
    生存时间ttl(Time To Live). 查看(ttl key)，设置(expire key 秒)
##### 4.Redis默认端口？
    6379
##### 5.Redis默认多少个数据库？
    16
##### 6.Redis内存回收算法有哪些？
    volatile-lru：使用LRU算法移除key，只对设置了过期时间的键
    allkeys-lru：使用LRU算法移除key
    volatile-random：在过期集合中移除随机的key，只对设置了过期时间的键
    allkeys-random：移除随机的key
    volatile-ttl：移除那些TTL值最小的key，即那些最近要过期的key
    noeviction：不进行移除。针对写操作，只是返回错误信息
##### 7.Redis默认是否是通过守护进程启动的？通过什么配置？
    不是，通过通用配置里的daemonize配置。
##### 8.Redis持久化有哪些？区别是啥？
    RDB和AOF
    RDB是按照指定时间间隔将内存中的数据集快照写入磁盘；
    AOF是将执行过的命令记录下来，以日志形式保存下来；
##### 9.RDB和AOF优缺点？
    RDB优点：适合大规模的数据恢复，对数据完整性和一致性要求不高；
    RDB缺点：会丢失最后一次快照后的所有修改；
    AOF优点：可以设置always、everysec和no为每次同步、每秒同步和不同步。通常会丢失最近1秒的操作。
    AOF缺点：相同数据集而言aof文件要大于rdb文件，恢复速度慢于rdb；
##### 10.Redis模式使用哪种序列化？
    默认使用rdb持久化，同时开启时候会优先载入aof进行数据恢复；
##### 11.Redis事务相关命令？
    DISCARD
    EXEC
    MULTI
    UNWATCH
    WATCH
##### 12.ACID和CAP区别？
    ACID：
    A (Atomicity) 原子性
    C (Consistency) 一致性
    I (Isolation) 隔离性
    D (Durability) 持久性
    CAP：
    C:Consistency（强一致性）
    A:Availability（可用性）
    P:Partition tolerance（分区容错性）
##### 13.CAP能同时满足么？
    不能，最多能满足2个。Redis满足CP。
##### 14.你用过Redis的发布订阅么？
    线上环境没用过，通常会优先使用常用的消息队列。
##### 15.Redis主从配置时候Master挂掉了会怎样？
    会通过哨兵机制投票选举出来新的Master。


