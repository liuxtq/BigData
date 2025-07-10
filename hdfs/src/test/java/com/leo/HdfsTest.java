package com.leo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;


public class HdfsTest
{
    private static final String HDFS_URI = "hdfs://hadoop102:9870"; // Hadoop NameNode URI
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

    public void testReadFile() throws IOException {
        // 1. 创建 HDFS 配置
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", HDFS_URI);

        // 2. 获取 FileSystem 对象
        FileSystem fs = FileSystem.get(URI.create(HDFS_URI), conf);

        // 3. 定义本地文件和 HDFS 路径
        Path localPath = new Path("/path/to/local/file.txt"); // 改成你的
        Path hdfsPath = new Path("/user/hadoop/file.txt");

        // 下载文件
        Path downloadPath = new Path("/path/to/local/downloaded_file.txt"); // 改成你的
        fs.copyToLocalFile(hdfsPath, downloadPath);
        System.out.println("下载成功：" + hdfsPath + " -> " + downloadPath);

        // 关闭文件系统
        fs.close();
    }
}
