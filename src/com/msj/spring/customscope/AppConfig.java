package com.msj.spring.customscope;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/26
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();

        Map<String, Object> map = new HashMap<>();
        map.put("threadScope", new ThreadScope());

        // 配置scope
        customScopeConfigurer.setScopes(map);
        return customScopeConfigurer;
    }
}
