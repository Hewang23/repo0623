package com.atguigu.test;

import java.util.*;

/**
 * @author Hewang
 * @create 2020-05-11 14:49
 * @title
 */
public class DAO<T>{
    private Map<String,T> map=new HashMap<>();
    public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        T t = map.get(id);
        return t;
    }
    public void update(String id,T entity){
//        map.replace(id,map.get(id),entity);
        if(map.containsKey(id)){
            map.put(id,entity);
        }
    }
    public List<T> list(){
        Collection<T> values = map.values();
        List<T> list=new ArrayList();
        for(T t:values){
            list.add(t);
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }
}
