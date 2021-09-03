# mysql
1. mvcc多版本并发事务控制
- innodb每行记录后有三个隐藏字段：DB_ROW_ID 行id，DB_TRX_ID 事务id,DB_ROLL_PTR：回滚指针
- 当记录被多次修改时，DB_ROLL_PTR会记录为一个链表
- 在RR级别下，一个select会生成一个ReadView，主要包含一下几个属性
public class ReadView{
    int trx_ids[];
    // 低水位
    int up_limit_id;
    // 高水位
    int low_limit_id;
    // 当前事务id
    int creator_trx_id;
}
通过判断被访问版本的事务id trx_id
- 如果小于低水位，说明是生成前提交的，可以读到。
- 如果等于creator_trx_id，，说明是当前事务，可以读到。
- 如果大于高水位，说明生成前还没t提交，不可以读到。
- 如果大于低水位小于高水位，则判断trx_id是否存在于trx_ids中，如果存在，说明生成时是活跃的，无法读到。反之则可以读到。
判断时会拿当前记录事务的最新版本来比较，如果无法读到，则通过回滚指针DB_ROLL_PTR，一直找到当前事务可以读到的版本为止。

注意：在RC级别下，ReadView每次select都会生成，而在RR级别下，ReadView只在第一次select生成一次。

2. MVCC有没有解决幻读？
快照读情况下，只生成一次，必然解决幻读。
当前读情况下，无法解决。
所以RR级别下解决的幻读是依靠间隙锁或临键锁解决的。