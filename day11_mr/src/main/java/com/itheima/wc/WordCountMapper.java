package com.itheima.wc;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.io.Serializable;

//KEYIN, VALUEIN, KEYOUT, VALUEOUT
// 泛型: 规定 k v 的类型
// 输入的 kv KEYIN, VALUEIN:输入k:行偏移量 LongWritable 输入v:整行内容 Text
// 输出的 kv KEYOUT, VALUEOUT:输出k:单词 Text 输出v:1 IntWritable
// 数据在网络中进行传输 -> 序列化 -> 实现序列化的接口 Serializable
// 所有的基本数据类型的包装类以及String都实现了 Serializable 接口 -- > 想到: kv的类型用的难道就是java中的这些包装类类型
// 卡老师, 嫌弃java中 Serializable 序列化的方式 效率太低(太重) -> 自己搞了一个序列化(轻量型)
// 自定义了一些数据 实现了 自己的序列化

public class WordCountMapper extends Mapper<LongWritable ,Text, Text, IntWritable> {

    /**
     * 每一行内容 调用一次map方法
     *
     * @param key     输入k: 行偏移量
     * @param value   输入v: 整行内容
     * @param context 上下文对象 将数据写出到下一个阶段
     * @throws IOException
     * @throws InterruptedException
     */


    @Override
    protected void map(LongWritable key,Text value, Context context) throws IOException, InterruptedException {
        // 获取到整行内容 hadoop空格hadoop --> hadoop 1 hadoop 1
        String line = value.toString(); //转成String
        // 将数据进行切割 对象调用方法之前 最好先做一个非空判断
        "".split(" ");
        //if(!"".equals(line))
        // if (line == null || line.isEmpty()) {
        // if (集合 == null || 集合.size() == 0) {
        // if (数组 == null || 数组.length == 0) {
        if(line != null && !"".equals(line)){
            String[] words = line.split(" ");
            for (String word : words) {
                //写出
                // hello 1
                // hello 1
                context.write(new Text(word),new IntWritable(1));
            }
        }

    }
}
