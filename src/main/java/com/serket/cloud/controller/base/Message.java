package com.serket.cloud.controller.base;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by WangYa on 2015/5/19.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Message implements Serializable {


    private String message;
    private ReturnStatus status;
    private Integer code;
    private Object obj;

    public Message(ReturnStatus status, Object obj) {
        this.status = status;
        this.obj = obj;
    }
    public Message(ReturnStatus status){
        this.status=status;
    }
    public Message(ReturnStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ReturnStatus getStatus() {
        return status;
    }

    public void setStatus(ReturnStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
