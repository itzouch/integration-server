### 什么是redo log？  （持久性）
redo log是InnoDb独特的日志文件，它记录的是数据的更改，和binlog有点像，但是它记录的是**每次操作在某个页上做了什么修改**。
redo log也有buffer，然后落盘，具体可以配置。
它的作用是：当修改记录的时候，内存中已经更改，但是还没落盘，此时数据库挂了的话，可以根据redo log来恢复丢失的数据。redo log是顺序写入磁盘的，速度很快，
他记载的是物理变化（xxx页做了xxx修改），体积也很小，恢复很快。

### redo log和bin log的区别
1. binlog记载的是update/delete/insert这样的SQL语句，而redo log记载的是物理修改的内容（xxxx页修改了xxx）。
redo log 记录的是数据的物理变化，binlog 记录的是数据的逻辑变化
2. redo log的作用是为持久化而生的。写完内存，如果数据库挂了，那我们可以通过redo log来恢复内存还没来得及刷到磁盘的数据，
将redo log加载到内存里边，那内存就能恢复到挂掉之前的数据了。
3. binlog的作用是复制和恢复而生的。主从数据一致需要用binlog来同步。
4. redo log事务开始的时候，就开始记录每次的变更信息，而binlog是在事务提交的时候才记录。
5. MySQL需要保证redo log和binlog的数据是一致的，通过两阶段提交来保证。
 - 阶段1：InnoDBredo log 写盘，InnoDB 事务进入 prepare 状态
 - 阶段2：binlog 写盘，InooDB 事务进入 commit 状态


参考：
于是新有的问题又出现了：我写其中的某一个log，失败了，那会怎么办？现在我们的前提是先写redo log，再写binlog，我们来看看：

如果写redo log失败了，那我们就认为这次事务有问题，回滚，不再写binlog。

如果写redo log成功了，写binlog，写binlog写一半了，但失败了怎么办？我们还是会对这次的事务回滚，将无效的binlog给删除（因为binlog会影响从库的数据，所以需要做删除操作）

如果写redo log和binlog都成功了，那这次算是事务才会真正成功。


### 什么是undo log？  （原子性）
undo log主要有两个作用：回滚和多版本控制(MVCC)
在数据修改的时候，不仅记录了redo log，还记录undo log，如果因为某些原因导致事务失败或回滚了，可以用undo log进行回滚。
undo log主要存储的也是逻辑日志，比如我们要insert一条数据了，那undo log会记录的一条对应的delete日志。我们要update一条记录时，它会记录一条对应相反的update记录。
这也应该容易理解，毕竟回滚嘛，跟需要修改的操作相反就好，这样就能达到回滚的目的。因为支持回滚操作，所以我们就能保证：“一个事务包含多个操作，这些操作要么全部执行，要么全都不执行”。【原子性】
因为undo log存储着修改之前的数据，相当于一个前版本，MVCC实现的是读写不阻塞，读的时候只要返回前一个版本的数据就行了。

### 什么是bin log?
binlog记录了数据库表结构和表数据变更，比如update/delete/insert/truncate/create。
主要有两个作用：复制和恢复数据
1. MySQL在公司使用的时候往往都是一主多从结构的，从服务器需要与主服务器的数据保持一致，这就是通过binlog来实现的。

2. 数据库的数据被干掉了，我们可以通过binlog来对数据进行恢复。

总结：MySQL ACID
- 通过undo log保证原子性
- 通过事务保证一致性
- 通过MVCC保证隔离性
- 通过redo log保证持久性
