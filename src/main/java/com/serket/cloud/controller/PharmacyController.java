package com.serket.cloud.controller;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.controller.base.BaseController;
import com.serket.cloud.controller.base.Message;
import com.serket.cloud.util.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WangYa on 2015/5/19.
 */
@RequestMapping("/pharmacy")
public interface PharmacyController {

    /**
     * 注册一个商家
     * @param pharmacy
     * @return
     */
    @RequestMapping("/register")
    public Message register(Pharmacy pharmacy);

    /**
     * 商家登录
     * @param pharmacy
     * @return
     */
    @RequestMapping("/login")
    public Message login(Pharmacy pharmacy);

    /**
     * 查询商家列表
     * @param view
     * @param pharmacy
     * @return 商家列表
     */
    @RequestMapping("/list")
    public Page list(Page view, Pharmacy pharmacy);


    /**
     * 查询商家列表
     *
     * @return 商家列表
     */
    @RequestMapping("/alllist")
    public List<Pharmacy> list();


}
