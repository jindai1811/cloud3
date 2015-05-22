package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.service.PharmacyService;
import com.serket.cloud.service.base.BaseService;
import com.serket.cloud.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WangYa on 2015/5/21.
 */
@Service
@Transactional
public class PharmacyServiceImpl extends BaseServiceImpl<Pharmacy> implements PharmacyService {

}
