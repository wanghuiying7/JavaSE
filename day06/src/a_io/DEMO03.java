package a_io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class DEMO03 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //字符串 -> 字节数组: 这个动作叫 编码.
        //utf-8码表: 97, 98, 99, 49, 50, 51, -28, -67, -96, -27, -91, -67
        //gbk码表:   97, 98, 99, 49, 50, 51, -60, -29, -70, -61
        String s = "abc123你好";
        byte[] bys1 = s.getBytes();
        byte[] bys2 = s.getBytes("utf-8");
        byte[] bys3 = s.getBytes("gbk");
        System.out.println("bys1: " + Arrays.toString(bys1));
        System.out.println("bys2: " + Arrays.toString(bys2));
        System.out.println("bys3: " + Arrays.toString(bys3));
        System.out.println("----------------------");

        //字节数组 -> 字符串 : 这个动作叫 解码.
        byte[] bys = {97, 98, 99, 49, 50, 51, -28, -67, -96, -27, -91, -67};
//        byte[] bys = {97, 98, 99, 49, 50, 51, -60, -29, -70, -61};
        String utf8Str = new String(bys); //abc123你好 abc123���
        String gbkStr = new String(bys, "gbk"); //abc123浣犲ソ abc123你好
        System.out.println("utf8Str: " + utf8Str);
        System.out.println("gbkStr: " + gbkStr);



        // 用什么编码就用什么解码
    }
}
