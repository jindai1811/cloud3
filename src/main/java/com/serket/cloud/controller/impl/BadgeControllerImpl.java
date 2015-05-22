package com.serket.cloud.controller.impl;

import com.serket.cloud.controller.BadgeController;
import com.serket.cloud.controller.base.BaseController;
import com.serket.cloud.controller.base.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangYa on 2015/5/21.
 */
@RestController
public class BadgeControllerImpl extends BaseController implements BadgeController {

    public Message generateQRCode(@PathVariable("pharmacyid") String pharmacyid, @RequestParam("content") String content) {

        return null;
    }
}
