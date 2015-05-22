package com.serket.cloud.controller;

import com.serket.cloud.controller.base.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by WangYa on 2015/5/21.
 */
@RequestMapping("/prescription")
public interface Prescription {
    /**
     * ɨ��ά��
     * @param userid  �û�id
     * @param qrcode ��ά������
     * @return ��Ӧ����
     */
    @RequestMapping("/{userid}")
    public Message getContent(@RequestParam("userid")String userid,@RequestParam("qrcode") String qrcode);



}
