package com.msj.spring.customscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/26
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc
 */
@Scope("threadScope")
@Service
public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "Hello CustomScope";
    }
}
