package com.serket.cloud.controller;

import com.serket.cloud.controller.base.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by WangYa on 2015/5/19.
 */
@RequestMapping("/badge")
public interface BadgeController {
    /**
     * 生成二维
     * @param pharmacyid 药房id
     * @param content 内容
     * @return 二维码
     */
    @RequestMapping("/{pharmacyid}")
    public Message generateQRCode(@PathVariable("pharmacyid") String pharmacyid, @RequestParam("content") String content);
}
