package a_io;

/*
介绍字节流:
    为什么会出现字节流: 如果再文件中书写文本信息,且含有中文,在文件传输过程中,字节型数据,在不同的码表中占用的字节数不相同,汉字对应的字节的值
    也不相同, 当数据源和目的地文件编码不一致时会产生乱码问题 (此时根据不同的编码表传输不同的字符流,就可以快速获取信息)
    字符流 = 字节流 + 编码表

    常见的编码表:
        ASCII: 美国信息通用交换码
        GBK: 国标码
        UTF-8:国际通用码,也叫万国码

 */

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DEMO03 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //字符串 -> 字节数组: 这个动作叫 编码.
        // 将字符转换为字节型数据,此时叫做编码
        //utf-8码表: 97, 98, 99, 49, 50, 51, -28, -67, -96, -27, -91, -67
        //gbk码表:   97, 98, 99, 49, 50, 51, -60, -29, -70, -61
        String s = "abc123你好";
        byte[] bys1 = s.getBytes();
        byte[] bys2 = s.getBytes("utf-8");
        byte[] bys3 = s.getBytes("gbk");

        /*
        1.英文字母,数字,特殊符号,在不同的码表中都只占一个字符
        2.中文在gbk中占用2个字节, 在utf8中占用3个字节
        3.中文字符都是负数
         */

        System.out.println("bys1: " + Arrays.toString(bys1));
        System.out.println("bys2: " + Arrays.toString(bys2));
        System.out.println("bys3: " + Arrays.toString(bys3));
        System.out.println("----------------------");

        //字节数组 -> 字符串 : 这个动作叫 解码.
        // 字节数组,转换为字符串,这个动作叫做解码
        byte[] bys = {97, 98, 99, 49, 50, 51, -28, -67, -96, -27, -91, -67};
//        byte[] bys = {97, 98, 99, 49, 50, 51, -60, -29, -70, -61};
        String utf8Str = new String(bys); //abc123你好 abc123���
        String gbkStr = new String(bys, "gbk"); //abc123浣犲ソ abc123你好
        System.out.println("utf8Str: " + utf8Str);
        System.out.println("gbkStr: " + gbkStr);



        // 用什么字符集编码,就用什么字符集解码,否则会出现乱码现象
    }
}
