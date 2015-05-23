package com.serket.cloud.controller;

import com.serket.cloud.controller.base.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by WangYa on 2015/5/21.
 */
@RequestMapping("/prescription")
public interface PrescriptionController {
    /**
     * 扫二维码
     * @param userid  用户id
     * @param qrcode 二维码内容
     * @return 对应内容
     */
    @RequestMapping("/{userid}")
    public Message getContent(@RequestParam("userid")String userid,@RequestParam("qrcode") String qrcode);



}
