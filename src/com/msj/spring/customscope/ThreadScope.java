package com.msj.spring.customscope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/26
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 自定义scope
 */
public class ThreadScope implements Scope {

    private final ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String, Object>>(){
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = threadLocal.get();
        Object obj = scope.get(name);

        // 不存在则放入ThreadLocal
        if (obj == null) {
            obj = objectFactory.getObject();
            scope.put(name, obj);

            System.out.println("Not exists " + name + "; hashCode: " + obj.hashCode());
        } else {
            System.out.println("Exists " + name + "; hashCode: " + obj.hashCode());
        }

        return obj;
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope = threadLocal.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
