package com.serket.cloud.service;

import com.serket.cloud.bean.Badge;
import com.serket.cloud.service.base.BaseService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by WangYa on 2015/5/22.
 */
public interface BadgeService extends BaseService<Badge> {
    /**
     * 生成二维码
      * @param badge 内容 药店id
     * @return 二维码
     */
    public String generateQRCode(Badge badge);
}
