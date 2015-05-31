package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Sessioninfo;
import com.serket.cloud.service.SessionService;
import com.serket.cloud.service.base.BaseService;
import com.serket.cloud.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by WangYa on 2015/5/31.
 */
@Service
public class SessionServiceImpl extends BaseServiceImpl<Sessioninfo> implements SessionService {
    public int updateSessionInfo() {
        getSqlSession().update("");
        return 0;
    }
}
