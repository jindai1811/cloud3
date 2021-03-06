package com.serket.cloud.controller.impl;

import com.serket.cloud.bean.Badge;
import com.serket.cloud.controller.BadgeController;
import com.serket.cloud.controller.base.BaseController;
import com.serket.cloud.controller.base.Message;
import com.serket.cloud.service.BadgeService;
import javafx.scene.chart.BarChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangYa on 2015/5/21.
 */
@RestController
public class BadgeControllerImpl extends BaseController implements BadgeController {

    @Autowired
    private BadgeService service;

    public Message generateQRCode(@PathVariable("pharmacyid") String pharmacyid, @RequestParam("content") String content) {
        Badge badge = new Badge();
        badge.setPharmacyId(pharmacyid);
        badge.setContent(content);
        String qrCode = service.generateQRCode(badge);
        return qrCode == null ? failed("generate filed") : success(qrCode);
    }

    public Message getContent(@PathVariable("userid") String userid, @RequestParam("qrcode") String qrcode) {
        try {
            return success(service.getContent(userid, qrcode));
        } catch (Exception e) {
            return failed("get contetnt filed");
        }
    }
}
