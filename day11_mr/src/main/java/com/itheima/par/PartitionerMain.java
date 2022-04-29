package com.itheima.par;

import com.itheima.wc.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class PartitionerMain {
    public static void main(String[] args) throws Exception {
        // 1、创建建一个job任务对象
        Job job = Job.getInstance(new Configuration(), "partitioner");
        // 2、指定job所在的jar包中的主类(执行这个jar的时候 程序入口在哪里??) WordCountMain
        job.setJarByClass(PartitionerMain.class);

        // 3、指定源文件的读取方式类和源文件的读取路径
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("E:\\ITcast\\就业班教师内容（每日更新）\\Java\\day11_mr\\fake_其他资料\\03_资料\\自定义分区\\input\\partition.csv"));

        // 4、指定自定义的Mapper类和输出kv类型
        job.setMapperClass(PartitionerMapper.class);
        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

        // 5、shuffle阶段
        // 5.1 分区 自定义分区
        job.setPartitionerClass(MyPartitioner.class);
        // 注意: 分区的数量一定要跟 reduceTask的数量保持一致
        job.setNumReduceTasks(2);

        // 5.2 排序
        // 5.3 规约
        // 5.4 分组
        // 6、指定自定义的Reducer类和输出kv类型
        job.setReducerClass(PartitionerReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        // 7、指定输出方式类和结果输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        // 输出路径: 父路径需要存在 最后的路径不能存在 FileAlreadyExistsException
        TextOutputFormat.setOutputPath(job, new Path("E:\\ITcast\\就业班教师内容（每日更新）\\Java\\day11_mr\\fake_其他资料\\03_资料\\自定义分区\\output2"));

        // 8、将job提交到yarn集群 true:检测并打印job
        // 返回的结果为 true证明执行成功 false 执行失败
        boolean flag = job.waitForCompletion(true);

        // System.out.println(b ? "成功":"失败");
        System.exit(flag ? 0 : 1);


    }
}
