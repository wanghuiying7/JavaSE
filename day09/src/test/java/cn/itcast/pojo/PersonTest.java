package cn.itcast.pojo;

import org.junit.Test;


public class PersonTest {
    @Test
    public void  testPerson(){
        Person p = new Person();
        p.setName("柳岩");
        p.setAge(18);
        p.setSex("女");

        System.out.println(p.getName());
        System.out.println(p);
    }

}