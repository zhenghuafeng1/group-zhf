package demo.test;

import java.util.*;

public class MyTest {
    public static void main(String[] args) {
        WorkEventSource work = new WorkEventSource();    //（事件源）
        work.addListener(new ProJava()); //注册监听器
        work.addListener(new ProHtml());    //注册监听器
        work.toTime(true);
        System.out.println("------------");
        work.toTime(false);
    }
}
