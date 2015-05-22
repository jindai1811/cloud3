package com.serket.cloud.controller.base;

import java.awt.*;

/**
 * Created by WangYa on 2015/5/19.
 */
public class BaseController extends GlobeExceptionHandler {

    protected Message success(Object obj) {
        return new Message(ReturnStatus.OK,obj);
    }
    protected Message success(String message) {
        return new Message(ReturnStatus.OK,message);
    }
    protected Message failed(Object obj) {
        return new Message(ReturnStatus.FAILED,obj);
    }
    protected Message failed(String message) {
        return new Message(ReturnStatus.FAILED,message);
    }
}
