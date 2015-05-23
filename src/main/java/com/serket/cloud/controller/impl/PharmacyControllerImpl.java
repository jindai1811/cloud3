package com.serket.cloud.controller.impl;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.controller.PharmacyController;
import com.serket.cloud.controller.base.BaseController;
import com.serket.cloud.controller.base.Message;
import com.serket.cloud.service.PharmacyService;
import com.serket.cloud.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * Created by WangYa on 2015/5/19.
 */

@RestController
public class PharmacyControllerImpl extends BaseController implements PharmacyController {
    @Autowired
    private PharmacyService service;

    public Message register(Pharmacy pharmacy) {
        return success(pharmacy);
    }

    public Message login(Pharmacy pharmacy) {
        String accessToken= service.login(pharmacy);
        return accessToken==null?failed("User name or password error"):success(accessToken);
    }


    public Page list(Page view, Pharmacy pharmacy) {
        view.setWhere(pharmacy);
        service.list(view);
        return view;
    }

    public List<Pharmacy> list() {
        return service.findAll();
    }
}
