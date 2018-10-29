package com.repairsystem.service.Impl;

import com.repairsystem.RepairsystemApplication;
import com.repairsystem.entity.Administrator;
import com.repairsystem.service.AdministratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author CheungChingYin
 * @date 2018/10/28
 * @time 21:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepairsystemApplication.class)
public class AdministratorServiceImplTest {

    @Autowired
    private AdministratorService adminservice;

    @Test
    public void searchAllAdministrator() {
        List<Administrator> list = adminservice.searchAllAdministrator();
        for(Administrator admin : list){
            System.out.println(admin.getAdminName());
        }
    }

    @Test
    public void searchAdministratorById() {
        Administrator admin = adminservice.searchAdministratorById(2);
        System.out.println(admin.getAdminName());
    }

    @Test
    public void searchAdministratorByName() {
        List<Administrator> list = adminservice.searchAdministratorByName("李四");
        for(Administrator admin:list){
            System.out.println(admin.getAdminPhone());
        }
    }

    @Test
    public void loginAdministrator() {
        Administrator admin = adminservice.loginAdministrator("13841547255","test123456");
        System.out.println(admin.getAdminName()+";"+admin.getAdminPermission());
    }

    @Test
    public void administratorPhoneNumberIsExist() {
        boolean result = adminservice.administratorPhoneNumberIsExist("13842512342");
        System.out.println(result);
    }

    @Test
    public void saveAdministrator() {
        Administrator admin = new Administrator();
        admin.setAdminName("李四");
        admin.setAdminPassword("test13456");
        admin.setAdminPhone("13842512341");
        admin.setAdminPermission(1);
        adminservice.saveAdministrator(admin);
    }

    @Test
    public void updateAdministrator() {
        Administrator admin = new Administrator();
        admin.setAdminId(4);
        admin.setAdminPermission(0);
        adminservice.updateAdministrator(admin);
    }

    @Test
    public void deleteAdministrator() {
        adminservice.deleteAdministrator(3);
    }
}