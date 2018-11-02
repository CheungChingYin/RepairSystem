package com.repairsystem.service.Impl;

import com.repairsystem.dao.AdministratorMapper;
import com.repairsystem.entity.Administrator;
import com.repairsystem.exception.AdministratorIdIsNullException;
import com.repairsystem.exception.AdministratorNameIsNullException;
import com.repairsystem.exception.AdministratorPasswordIsNullException;
import com.repairsystem.exception.AdministratorPhoneIsNullException;
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

        if (StringUtils.isBlank(id.toString())) {
            throw new AdministratorIdIsNullException("传入的管理员ID为空");
        }
        return adminMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Administrator> searchAdministratorByName(String name) {

        if (StringUtils.isBlank(name)) {
            throw new AdministratorNameIsNullException("传入的管理员姓名为空");
        }

        Example example = new Example(Administrator.class);
        example.createCriteria().andLike("adminName", "%" + name + "%");

        return adminMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Administrator loginAdministrator(String phone, String password) {

        if (StringUtils.isBlank(phone)) {
            throw new AdministratorPhoneIsNullException("传入的管理员电话号码为空");
        }

        if (StringUtils.isBlank(password)) {
            throw new AdministratorPasswordIsNullException("传入的管理员密码为空");
        }

        password = PasswordEncryptionUtils.plainText2MD5Encrypt(password);
        Example example = new Example(Administrator.class);
        example.createCriteria().andEqualTo("adminPhone", phone).andEqualTo("adminPassword", password);

        Administrator admin = adminMapper.selectOneByExample(example);

        return admin;

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean administratorPhoneNumberIsExist(String number) {

        if (StringUtils.isBlank(number)) {
            throw new AdministratorPhoneIsNullException("传入的管理员密码为空");
        }

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

        if (StringUtils.isBlank(admin.getAdminId().toString())) {
            throw new AdministratorIdIsNullException("传入的管理员ID为空");
        }

        adminMapper.updateByPrimaryKeySelective(admin);

    }

    @Override
    public void deleteAdministrator(Integer id) {

        if (StringUtils.isBlank(id.toString())) {
            throw new AdministratorIdIsNullException("传入的管理员ID为空");
        }
        adminMapper.deleteByPrimaryKey(id);

    }
}
