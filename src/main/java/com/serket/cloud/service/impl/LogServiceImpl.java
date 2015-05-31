package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Log;
import com.serket.cloud.service.LogService;
import com.serket.cloud.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WangYa on 2015/5/28.
 */
@Service
@Transactional
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {


}
