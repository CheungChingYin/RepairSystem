package com.repairsystem.service.Impl;

import com.repairsystem.dao.AdministratorMapper;
import com.repairsystem.entity.Administrator;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.utils.PasswordEncryptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/28
 * @time 19:54
 */
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper adminMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Administrator> searchAllAdministrator() {
        return adminMapper.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Administrator searchAdministratorById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Administrator> searchAdministratorByName(String name) {

        Administrator admin = new Administrator();
        admin.setAdminName(name);

        return adminMapper.select(admin);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Administrator loginAdministrator(String user,String password) {

        if (StringUtils.isBlank(user) || StringUtils.isBlank(password)) {
            return null;
        }

        password = PasswordEncryptionUtils.plainText2MD5Encrypt(password);
        Example example = new Example(Administrator.class);
        example.createCriteria().andEqualTo("adminPhone",user).andEqualTo("adminPassword",password);

        Administrator admin = adminMapper.selectOneByExample(example);

        return admin;

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean administratorPhoneNumberIsExist(String number) {

        Administrator admin = new Administrator();
        admin.setAdminPhone(number);

        Administrator result = adminMapper.selectOne(admin);

        boolean flag = result != null;
        return flag;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveAdministrator(Administrator admin) {

        String password = admin.getAdminPassword();
        admin.setAdminPassword(PasswordEncryptionUtils.plainText2MD5Encrypt(password));

        adminMapper.insert(admin);
    }

    @Override
    public void updateAdministrator(Administrator admin) {

        adminMapper.updateByPrimaryKeySelective(admin);

    }

    @Override
    public void deleteAdministrator(Integer id) {

        adminMapper.deleteByPrimaryKey(id);

    }
}
