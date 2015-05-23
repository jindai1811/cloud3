package com.serket.cloud.service;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.service.base.BaseService;

/**
 * Created by WangYa on 2015/5/21.
 */
public interface PharmacyService extends BaseService<Pharmacy> {

    /**
     * 商户登录
     * @param pharmacy 商户信息
     * @return accessToken
     */
    String login(Pharmacy pharmacy);

}
