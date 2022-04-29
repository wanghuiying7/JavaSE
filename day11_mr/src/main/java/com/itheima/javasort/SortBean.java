package com.itheima.javasort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

// 这个SortBean就是key
// SortBean对象 不仅要进行排序还需要...序列化
// Comparable 排序 Writable(序列化接口)
// WritableComparable -> 继承了 Comparable Writable
public class SortBean implements WritableComparable<SortBean> {
    //字母
    private String first;
    //数字
    private int second;

    public SortBean() {
    }

    public SortBean(String first, int second) {
        this.first = first;
        this.second = second;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {

        this.second = second;
    }
    // 排序
    @Override
    public int compareTo(SortBean o) {
        int num = this.getFirst().compareTo(o.getFirst());
        if (num == 0){
            num = o.getSecond() - this.getSecond();
        }
        return num;
    }
    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        //序列化与发序列化的顺序要保持一致
        dataOutput.writeUTF(this.first);
        dataOutput.writeInt(this.second);
    }
    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.first = dataInput.readUTF();
        this.second = dataInput.readInt();
    }
}
