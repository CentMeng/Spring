package com.msj.spring.customscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/26
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc
 */

public class CustomScopeApplication {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(()->{
            //模拟执行耗时任务
            MessageService messageService = context.getBean(MessageService.class);
            messageService.getMessage();

            MessageService messageService2 = context.getBean(MessageService.class);
            messageService2.getMessage();
            //返回结果
            return "result";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(()->{
            //模拟执行耗时任务
            MessageService messageService = context.getBean(MessageService.class);
            messageService.getMessage();

            MessageService messageService2 = context.getBean(MessageService.class);
            messageService2.getMessage();
            //返回结果
            return "result";
        });

        try {
            task1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            task2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
