package com.itheima.group;

import org.apache.hadoop.io.WritableComparator;

public class MyGroup extends WritableComparator {
    @Override
    public int compare(Object a,Object b) {
        return super.compare(a, b);

    }

}
