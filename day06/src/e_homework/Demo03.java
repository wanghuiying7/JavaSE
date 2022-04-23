package e_homework;

//3. 随机点名器案例.
//提示: 高效的字符流一次读写一行.
	/*
		项目下有一个names.txt, 里边记录的是学员的名字, 格式如下(一个名字占一行)
			张三
			李四
			王五
			赵六
			...
		将上述所有数据读取出来, 存放到ArrayList<String>集合中, 然后随机从中获取一个名字即可.
	*/

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        // 由于我们希望随机获取,所以建议使用你随机索引值,获取元素,此时可以用arraylist集合
        //1.创建一个容器,保存所有的学员姓名信息 (ArrayList)
        ArrayList<String> list = new ArrayList<>();
        //2.创建字符高效流, 获取文件中的姓名
        BufferedReader br = new BufferedReader(new FileReader("Day06/data/names.txt"));
        //3.读取数据放入集合中
        String line;
        while ((line= br.readLine())!=null){
            list.add(line);
        }
        //4.关闭流
        br.close();

        //5.输出随机名字
        System.out.println(list.get((int)(Math.random()* list.size())));

//        Random r = new Random();
//        int i = r.nextInt(list.size());
//        System.out.println("随机点到的是："+list.get(i));

    }
}
