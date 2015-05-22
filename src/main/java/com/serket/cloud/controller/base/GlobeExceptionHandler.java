package com.serket.cloud.controller.base;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/5/10.
 */

public class GlobeExceptionHandler {

    @ExceptionHandler({Exception.class})
    public Message s(Exception e){
        Message message= new Message(ReturnStatus.FAILED);
        if(e instanceof MissingServletRequestParameterException){
            message.setMessage("MissingServletRequestParameterException");
        }else{
            message.setMessage(e.toString()+"     "+e.getClass());
        }
      //  msg.put("e",e.toString()+"   "+e.getClass());
        return message;
    }

}
