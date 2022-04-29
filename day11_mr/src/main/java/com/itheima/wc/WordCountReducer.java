package com.itheima.wc;

/*
KEYIN, VALUEIN, 输入k:  输入v:跟map输出保持一致
KEYOUT, VALUEOUT 输出k:Text(word) 输出v:IntWritable(单词的数量)
 */

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, IntWritable,Text, IntWritable> {
    /**
     * {word,word,word,word,word}:{1,1,1,1,1}
     * 每一组的数据会调用一次 reduce方法
     * @param key 分组的key(word)
     * @param values key对应的所有的value值({1,1,1,1,1})
     * @param context 上写文对象 写出到TextOutputFormat --> 写出到文件中
     * @throws IOException 异常
     * @throws InterruptedException 异常
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        // {1,1,1,1,1}
        for (IntWritable value : values) {
            // value.get() 获取到IntWritable中的int值
            count += value.get();
        }
        // word:{1,1,1,1,1} --> word:5
        context.write(key, new IntWritable(count));
    }
}
