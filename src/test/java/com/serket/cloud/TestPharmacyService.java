package com.serket.cloud;

import com.serket.cloud.bean.Pharmacy;
import com.serket.cloud.service.PharmacyService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * Created by WangYa on 2015/5/21.
 */
public class TestPharmacyService {
    @Test
      public void testSave(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        PharmacyService service= (PharmacyService) context.getBean(PharmacyService.class);

        for (int i = 0; i < 100; i++) {
            Pharmacy pharmacy=new Pharmacy();
            pharmacy.setName("tome"+i);
            pharmacy.setPassword("123456"+i);
            pharmacy.setAddress("北京海淀");
            pharmacy.setPhone("12333333333333");
            pharmacy.setRegisterDate(new Timestamp(System.currentTimeMillis()));
            pharmacy.setRemarks("beizhu");
            pharmacy.setState(0);
          //  service.save(pharmacy);
        }



    } @Test
      public void testList(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        PharmacyService service= (PharmacyService) context.getBean(PharmacyService.class);
     //   service.findAll();
    }
}
