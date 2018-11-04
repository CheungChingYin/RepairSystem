package com.repairsystem.service.Impl;

import com.repairsystem.dao.ClassMapper;
import com.repairsystem.entity.Class;
import com.repairsystem.entity.vo.ClassVO;
import com.repairsystem.exception.ClassIdIsNullException;
import com.repairsystem.exception.ClassNameIsNullException;
import com.repairsystem.service.ClassService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 12:08
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Class> searchAllClass() {
        return classMapper.getAllClass();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Class searchClassById(Integer id) {

        if (StringUtils.isBlank(id.toString())) {
            throw new ClassIdIsNullException("传入的实训室ID为空");
        }
        return classMapper.getClassById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Class> searchClassByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new ClassNameIsNullException("传入的实训室名称为空");
        }

        return classMapper.getClassByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveClass(Class classes) {
        classMapper.insert(classes);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateClass(Class classes) {
        if (StringUtils.isBlank(classes.getClassId().toString())) {
            throw new ClassIdIsNullException("传入的实训室ID为空");
        }
        classMapper.updateByPrimaryKeySelective(classes);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteClass(Integer id) {
        if (StringUtils.isBlank(id.toString())) {
            throw new ClassIdIsNullException("传入的实训室ID为空");
        }
        classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void increaseComputerEnable(Integer classId) {

        Class classes = classMapper.selectByPrimaryKey(classId);
        Integer computerEnable = classes.getComputerEnable() + 1;
        Integer computerDisable = classes.getComputerDisable() - 1;
        classes.setComputerEnable(computerEnable);
        classes.setComputerDisable(computerDisable);
        classMapper.updateByPrimaryKeySelective(classes);
    }

    @Override
    public void reduceCompleteEnable(Integer classId) {

        Class classes = classMapper.selectByPrimaryKey(classId);
        Integer computerEnable = classes.getComputerEnable() - 1;
        Integer computerDisable = classes.getComputerDisable() + 1;
        classes.setComputerEnable(computerEnable);
        classes.setComputerDisable(computerDisable);
        classMapper.updateByPrimaryKeySelective(classes);
    }
}
