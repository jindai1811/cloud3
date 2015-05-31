package com.serket.cloud.service.impl;

import com.serket.cloud.bean.Badge;
import com.serket.cloud.service.BadgeService;
import com.serket.cloud.service.base.BaseService;
import com.serket.cloud.service.base.BaseServiceImpl;
import com.serket.cloud.util.Encryption;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangYa on 2015/5/22.
 */
@Service
@Transactional
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

    public String getContent(String userid, String qrcode) {
             // 更新药单 ,
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userid", userid);
            map.put("qrcode", qrcode);
            //扫描的时候更新日期,如果不存在就会报错,return null
            getSqlSession().update("updataUserid", map);
            //查询内容
            Badge  badge = getSqlSession().selectOne("getContent", map);
            //如果存在就创建历史记录, 创建历史记录
            map.put("confirmTime", new Timestamp(System.currentTimeMillis()));
            map.put("badgeId",badge.getId());
            getSqlSession().insert("addHistrory", map);
            return badge.getContent();

    }
}
