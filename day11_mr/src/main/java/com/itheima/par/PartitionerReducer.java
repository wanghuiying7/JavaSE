package com.itheima.par;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

// KEYIN, IntWritable,
// VALUEIN, Text
// KEYOUT, 整行数据
// VALUEOUT NullWritable
public class PartitionerReducer extends Reducer<IntWritable, Text, Text, NullWritable> {
    //{1,1,1}                {5	0	1	2017-07-31 23:30:18	837259	1,5	0	1	2017-07-31 23:30:18	837259	1,5	0	1	2017-07-31 23:30:18	837259	1}
    // key 1(中奖号)
    // value 迭代器(中奖号对应的所有的记录)
    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            // value 整行数据
            // NullWritable.get() 返回 NullWritable 对象
            context.write(value,NullWritable.get());
        }
    }
}
