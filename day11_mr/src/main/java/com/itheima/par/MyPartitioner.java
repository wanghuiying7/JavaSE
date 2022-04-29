package com.itheima.par;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner<IntWritable, Text> {
    @Override
    public int getPartition(IntWritable key, Text value, int numReduceTasks) {
        // 根据key的大小 进行自定义分区
        int nymKey = key.get();
        if (nymKey < 15) {
            return 0;
        } else {
            return 1;
        }
    }
}
