package com.leo.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WcDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.setProperty("hadoop.home.dir", "D:\\Program Files\\hadoop");
        // 1. 创建Job
        Configuration conf = new Configuration();
        conf.set("hadoop.native.lib", "false");
// 提交到集群
//        conf.set("mapreduce.framework.name", "yarn");
//        conf.set("yarn.resourcemanager.address", "rm-host:8032");
//        conf.set("fs.defaultFS", "hdfs://namenode:9000");
        Job job = Job.getInstance(conf, "word count");
        // 2.设置参数
        job.setJarByClass(WcDriver.class);
        job.setMapperClass(WcMapper.class);
        job.setReducerClass(WcReducer.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //
        FileInputFormat.addInputPath(job, new Path("data/input"));
        FileOutputFormat.setOutputPath(job, new Path("data/output"));

// 提交到集群
//        FileInputFormat.setInputPaths(job, new Path("/input"));
//        FileOutputFormat.setOutputPath(job, new Path("/output"));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
