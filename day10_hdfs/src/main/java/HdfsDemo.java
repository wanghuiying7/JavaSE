import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.kerby.util.IOUtil;
import org.junit.Test;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

public class HdfsDemo {
    @Test
    public void getFileSystem1() throws IOException {
        Configuration configuration = new Configuration();
        //指定我们使用的文件系统类型:
        configuration.set("fs.defaultFS", "hdfs://node1:8020/");
        //获取指定的文件系统
        FileSystem fileSystem = FileSystem.get(configuration);
        System.out.println(fileSystem.toString());
    }

    @Test
    public void getFileSystem2() throws  Exception{
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://node1:8020"), new       Configuration());
        System.out.println("fileSystem:"+fileSystem);
    }

    //1.获取FileSystem对象 文件系统对象
    @Test
    public void show1() throws Exception{
//        //LocalFileSystem 当前win文件系统对象 (C D E F)
//        Configuration conf1 = new Configuration();
//        FileSystem fs1 = FileSystem.newInstance(conf1);
//        System.out.println(fs1);
//        System.out.println("-------------------");
//        //获取hdfs的文件系统对象 但是用户名使用的是本机的
//        Configuration conf2 = new Configuration();
//        conf2.set("fs.defaultFS","hdfs://node1:9000");
//        FileSystem fs2 = FileSystem.newInstance(conf2);
//        System.out.println(fs2);
//        System.out.println("-------------------");
        //获取hdfs的文件系统对象 设置用户名
        //URI uri, 地址 file:///  虚拟机:  hdfs://
        // final Configuration conf, 配置文件对象
        // String user 用户名
        //伪装一个用户 创建文件系统对象
        FileSystem fs3 = FileSystem.newInstance(new URI("hdfs://node1:8020"), new Configuration(), "root");
        System.out.println(fs3);
    }
    //查看根节点下 所有的文件
    @Test
    public void show2() throws Exception{
        //1.获取文件系统对象
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://node1:8020"), new Configuration(), "root");
        //2.获取根路径下所有的文件(集合/迭代器/数组)
        //final Path f, 路径
        //final boolean recursive 是否递归 true代表递归
        //文件状态对象的迭代器
        RemoteIterator<LocatedFileStatus> listFiles = fileSystem.listFiles(new Path("/"), true);
        //获取每一个文件状态的对象
        while(listFiles.hasNext()){
            LocatedFileStatus fileStatus = listFiles.next();
            System.out.println(fileStatus.getPath());//获取文件路径
            System.out.println(fileStatus.getPath().getName());//获取文件名
            System.out.println("-----------------------------------------------------------------------");
        }
        //释放资源
        fileSystem.close();
    }

    //HDFS上创建文件夹
    @Test
    public void mkdirs() throws Exception{
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://node1:8020/"), new Configuration(), "root");
        fileSystem.mkdirs(new Path("/test"));
        fileSystem.close();
    }

    @Test
    public void downLoad() throws Exception{
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://node1:8020/"), new Configuration(), "root");
        //从hdfs中读
        FSDataInputStream inputStream = fileSystem.open(new Path("/test/aaa.txt"));
        //写出到 本地
        FileOutputStream outputStream = new FileOutputStream("E:/ccc.txt");
        // 文件的复制
        IOUtils.copy(inputStream,outputStream);
        // 关闭流
        IOUtils.closeQuietly(outputStream);
        IOUtils.closeQuietly(inputStream);
        fileSystem.close();
    }

    //文件上传
    @Test
    public void upLoad()  throws Exception{
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://node1:8020/"),new Configuration(), "root");
        //上传操作 从本地复制到hdfs
        //fileSystem.copyFromLocalFile(new Path("E:/ccc.txt"), new Path("/test/"));
        //下载操作
        fileSystem.copyToLocalFile(new Path("/test/ccc.txt"), new Path("E:\\34期"));
        fileSystem.close();
    }

    //文件合并
    @Test
    public void joinFile()  throws Exception{
        //1.hdfs文件系统
        FileSystem fileSystem = FileSystem.newInstance(new URI("hdfs://node1:8020/"), new Configuration(), "root");
        //2.本地文件系统
        LocalFileSystem localFileSystem = FileSystem.getLocal(new Configuration());
        //3.获取hdfs输出流
        FSDataOutputStream outputStream = fileSystem.create(new Path("/test/big.txt"));
        //4.本地文件系统获取到所有的小文件
        FileStatus[] fileStatuses = localFileSystem.listStatus(new Path("E:\\34期\\day10_maven与hdfs\\03_资料\\small"));
        //5.遍历所有的小文件 每一个小文件都创建一个输入流
        for (FileStatus fileStatus : fileStatuses) {
            Path path = fileStatus.getPath();
            // 获取当前文件的输入流
            FSDataInputStream inputStream = localFileSystem.open(path);
            //6.在循环内 输入流读的内容 通过输出流写出
            IOUtils.copy(inputStream, outputStream);
            //7.关闭输入流
            IOUtils.closeQuietly(inputStream);
        }
        //8.在循环外(循环执行结束 所有的小文件全部写出到了hdfs) 关闭输出流
        IOUtils.closeQuietly(outputStream);
        //9.关闭文件系统对象
        localFileSystem.close();
        fileSystem.close();
    }
}
