package com.atguigu.java;

import com.atguigu.utility.User;
import org.junit.Test;

import java.util.*;

/**
 * @author Hewang
 * @create 2020-05-06 13:12
 * @title   关于TreeSet
 * >TreeSet:可以按照添加对象的属性进行排序，因此对象需一致
 * >TreeSet中添加数据体现不可重复性依赖于compareTo方法
 * 可通过自然排序和定制排序
 *      自然排序中：比较两个对象是否相同的标准为compareTo()返回0  而不是equals()
 *
 *
 */
public class SetInfo2 {
    //添加的数据要求为相同类的对象
    //两种排序方式
    @Test
    public void test1(){
        Set set = new TreeSet();
//        set.add(123);
//        set.add("AA");
//        set.add("CC");
//        set.add(89);
//        set.add(76);
//        set.add(456);
//        set.add(123);//实际没有添加成功
        set.add(new User("Bao",23));
        set.add(new User("Dao",23));
        set.add(new User("Bdo",23));
        set.add(new User("Bko",23));
        set.add(new User("Bko",56));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2() {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    int compare = -u1.getName().compareTo(u2.getName());
                    if (compare != 0) {
                        return compare;
                    } else {
                        return Integer.compare(u1.getAge(), u2.getAge());
                    }
                } else {
                    throw new RuntimeException("输入数据不匹配");
                }
            }
        };
        Set set = new TreeSet(com);
        set.add(new User("Bao", 23));
        set.add(new User("Dao", 23));
        set.add(new User("Bdo", 23));
        set.add(new User("Bko", 23));
        set.add(new User("Bko", 56));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
