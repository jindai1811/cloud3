package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.service.PharmacyService;
import com.serket.cloud.service.base.BaseService;
import com.serket.cloud.service.base.BaseServiceImpl;
import com.serket.cloud.util.Encryption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WangYa on 2015/5/21.
 */
@Service
@Transactional
public class PharmacyServiceImpl extends BaseServiceImpl<Pharmacy> implements PharmacyService {

    public String login(Pharmacy pharmacy) {
        Pharmacy p = getSqlSession().selectOne(getMapperNamespace() + ".login", pharmacy);
        if (p != null && p.getState() == 0) {
            // 生成访问密钥
            String accessToken = Encryption.accessToken();

            return accessToken;
        }
        return null;
    }
}
