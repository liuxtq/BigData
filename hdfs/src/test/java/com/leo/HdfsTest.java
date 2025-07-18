package com.leo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;

/**
 * 如果hdfs设置了访问权限，需要再jvm启动时传入参数 -DHADOOP_USER_NAME=atguigu
 */
public class HdfsTest
{
    private static final String HDFS_URI = "hdfs://hadoop102:8020"; // Hadoop NameNode URI
    @Test
    public void testWriteFile() throws IOException {
        // 1. 创建 HDFS 配置
        Configuration conf = new Configuration();
//        conf.set("fs.defaultFS", HDFS_URI);

        // 2. 获取 FileSystem 对象
        FileSystem fs = FileSystem.get(URI.create(HDFS_URI), conf);

        // 3. 定义本地文件和 HDFS 路径
        Path localPath = new Path("D:\\workspace\\readme.txt"); // 改成你的
        Path hdfsPath = new Path("/leo/hadoop/readme.txt");

        // 上传文件
        fs.copyFromLocalFile(false, true, localPath, hdfsPath);
        System.out.println("上传成功：" + localPath + " -> " + hdfsPath);

        // 关闭文件系统
        fs.close();
    }
    @Test
    public void testReadFile() throws IOException {
        System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop");
        // 1. 创建 HDFS 配置
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", HDFS_URI);

        // 2. 获取 FileSystem 对象
        FileSystem fs = FileSystem.get(URI.create(HDFS_URI), conf);

        // 3. 定义本地文件和 HDFS 路径
        Path hdfsPath = new Path("/leo/hadoop/readme.txt");
        Path downloadPath = new Path("D:\\downloaded_file.txt"); // 改成你的

        // 下载文件
        fs.copyToLocalFile(hdfsPath, downloadPath);
        System.out.println("下载成功：" + hdfsPath + " -> " + downloadPath);

        // 关闭文件系统
        fs.close();
    }
}
