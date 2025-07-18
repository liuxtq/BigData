## 问题1   HDFS-NameNode和SecondaryNameNode的工作流程

![NN_2NN.png](src%2Fmain%2Fresources%2Fimages%2FNN_2NN.png)

> SecondaryNameNode请求执行chkpoint的阈值：
> - 1 定时时间（默认1小时）
> - 2 edits中的数量达到设定要求（默认100万次）

## 问题2 HDFS-NameNode和DataNode的工作流程

![NN_DN.png](src%2Fmain%2Fresources%2Fimages%2FNN_DN.png)
> 第5步，超过10分钟指的是：10分钟+30秒（10分钟后重试10次，每次间隔3秒）

## 问题3 HDFS-机架感知策略
"7"型结构，主要考虑两方面因素：1 读写速度 2 数据安全
![NN_jijiaganzhi.png](src%2Fmain%2Fresources%2Fimages%2FNN_jijiaganzhi.png)
原则
>**当副本数为3时**
> 
> 第一个副本在Client所处的节点上。
> 
> 第二个副本在另一个机架的随机节点。
> 
> 第三个副本在第二个副本所在机架的不同节点。

> **副本数大于3时**
>
> 则随机确定第4个副本的位置，同时将每个机架的副本数量保持在上限以下：（副本数-1）/机架数 + 2

## 问题4 HDFS-安全模式问题
![security_mode_1.png](src%2Fmain%2Fresources%2Fimages%2Fsecurity_mode_1.png)
![security_mode_2.png](src%2Fmain%2Fresources%2Fimages%2Fsecurity_mode_2.png)
![security_mode_3.png](src%2Fmain%2Fresources%2Fimages%2Fsecurity_mode_3.png)
![security_mode_4.png](src%2Fmain%2Fresources%2Fimages%2Fsecurity_mode_4.png)
![security_mode_5.png](src%2Fmain%2Fresources%2Fimages%2Fsecurity_mode_5.png)

## 问题5 HDFS-动态上下线问题

### 集群资源不够用了怎么办？
![dynamic_online_offline_1.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_1.png)
### 如何新增服务器节点（节点服役）？
![dynamic_online_offline_2.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_2.png)
![dynamic_online_offline_5.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_5.png)

### 如何移除服务器节点（节点退役）？
![dynamic_online_offline_3.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_3.png)
![dynamic_online_offline_6.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_6.png)
![dynamic_online_offline_7.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_7.png)
![dynamic_online_offline_8.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_8.png)

### 新增和移除节点后需要做什么工作？
![dynamic_online_offline_4.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fdynamic_online_offline_4.png)

## 问题6 HDFS-限额机制问题
![file_limit_1.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ffile_limit_1.png)
![file_limit_2.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ffile_limit_2.png)
![file_limit_3.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ffile_limit_3.png)
> 空间限额=block数量 * 副本数 * 128M 

## 问题7 HDFS-垃圾桶机制问题
![trash_1.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ftrash_1.png)
![trash_2.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ftrash_2.png)
![trash_3.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Ftrash_3.png)

## 问题8 HDFS-快照机制问题
![snapshot_1.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fsnapshot_1.png)
![snapshot_2.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fsnapshot_2.png)
![snapshot_3.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fsnapshot_3.png)
![snapshot_4.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Fsnapshot_4.png)
> 快照恢复 
> hdfs dfs -mkdir /test1
> hdfs dfs -cp /test/.snapshot/mysnap1 /test1

## 问题9 HDFS-归档机制问题
![archive_1.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Farchive_1.png)
![archive_2.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Farchive_2.png)
![archive_3.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Farchive_3.png)
**mr程序读取archive包中的小文件**
![archive_4.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Farchive_4.png)
![archive_5.png](hdfs%2Fsrc%2Fmain%2Fresources%2Fimages%2Farchive_5.png)