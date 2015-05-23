package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Badge;
import com.serket.cloud.service.BadgeService;
import com.serket.cloud.service.base.BaseService;
import com.serket.cloud.service.base.BaseServiceImpl;
import com.serket.cloud.util.Encryption;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by WangYa on 2015/5/22.
 */
@Service
public class BadgeServiceImpl extends BaseServiceImpl<Badge> implements BadgeService {
    public String generateQRCode(Badge badge) {
        try {
            String qrcode = Encryption.QRCode();
            badge.setQrCode(qrcode);
            // 设置当前系统时间
            badge.setCreateDate(new Timestamp(System.currentTimeMillis()));
            //设置默认状态为0
            badge.setState(0);
            save(badge);
            return qrcode;
        } catch (Exception e) {
            //如果异常了返回为null
            e.printStackTrace();
            return null;
        }

    }
}
