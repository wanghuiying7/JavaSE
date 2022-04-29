package com.itheima.par;



import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

// KEYIN, 行偏移量
// VALUEIN, 整行内容
// KEYOUT,  中奖号
// VALUEOUT 整行内容
public class PartitionerMapper extends Mapper<LongWritable, Text, IntWritable,Text> {
    @Override

    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1
        // 0
        // 1
        // 2017-07-31 23:10:12
        // 837255
        // 6
        // 4+1+1=6
        // 小,双
        // 0
        // 0.00
        // 0.00
        // 1
        // 0.00
        // 1
        // 1
        String line = value.toString();
        if (line != null && !line.isEmpty()){
            String[] split = line.split("\t");
            //中奖号的类型是字符串类型
            context.write(new IntWritable(Integer.parseInt(split[5])),value);
        }
    }
}
