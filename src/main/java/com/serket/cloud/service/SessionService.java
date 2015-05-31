package com.serket.cloud.service;

import com.serket.cloud.bean.Sessioninfo;
import com.serket.cloud.service.base.BaseService;

/**
 * Created by WangYa on 2015/5/31.
 */
public interface SessionService extends BaseService<Sessioninfo> {
    int  updateSessionInfo();
}
