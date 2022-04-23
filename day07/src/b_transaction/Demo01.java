package b_transaction;

/*
事务介绍：
    概述：事务指的是逻辑上的一组操作，组成该操作各个逻辑单元，要么全部执行成功，要么全部执行失败
    特征(ACID):
        1.原子性：指的就是组成事务的各个逻辑单元，要么全部执行成功，要么全部执行失败。
        2.一致性：指的是事务执行前后，数据要保持一致
        3.隔离性：指的是事务执行的时候，不能该收到其他事务的干扰
        4.持久性：无论是否执行成功与否，结果都会永久的存储倒数据表中
    如果考虑隔离性：
        脏读：指的是一个事务读到了另一个事务未提交的数据，导致多次查询结果不一致
        不可重复读：指的是一个事务读取到了另一个事务已经提交的（update）数据，导致一个事务中多次查询结果不一致；
        虚读/幻读：指的是一个事务读取到了另一个事务已经提交（insert）的数据，导致一个事务中多次查询结果不一致

    考虑隔离性的时候，也要考虑隔离级别：
        read uncommitted
        read committed
        repeatable read
        serializable
        隔离性: read uncommitted < read committed < repeatable read < serializable
        安全性: read uncommitted < read committed < repeatable read < serializable
        // 一般情况下,方案不会选择效率最高的,也不会选择安全性最高的,而是折中方案
        效率: read uncommitted > read committed > repeatable read > serializable

    数据库中默认的隔离级别:
        Mysql : repeatable read
        Oracle: read committed  (更适合承担大型的数据管理任务)



*/

public class Demo01 {
}
