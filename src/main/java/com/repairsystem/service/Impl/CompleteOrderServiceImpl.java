package com.repairsystem.service.Impl;

import com.repairsystem.dao.CompleteOrderMapper;
import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.entity.Orders;
import com.repairsystem.exception.CompleteOrderIdIsNullException;
import com.repairsystem.service.CompleteOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 21:03
 */
@Service
public class CompleteOrderServiceImpl implements CompleteOrderService {

    @Autowired
    private CompleteOrderMapper completeOrderMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CompleteOrder> searchAllCompleteOrder() {

        return completeOrderMapper.getAllCompleteOrder();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public CompleteOrder searchCompleteOrderById(Integer id) {

        if(StringUtils.isBlank(id.toString())){
            throw new CompleteOrderIdIsNullException("传入的完成表单ID不能为空");
        }
        return completeOrderMapper.getCompleteOrderById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer getCompleteOrderCount() {
        return completeOrderMapper.getCompleteOrderCount();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CompleteOrder> searchCompleteOrderByKeyWord(String keyWord) {
        return completeOrderMapper.getCompleteOrderByKeyWord(keyWord);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveCompleteOrder(CompleteOrder completeOrder) {

        completeOrderMapper.insertSelective(completeOrder);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateCompleteOrder(CompleteOrder completeOrder) {

        completeOrderMapper.updateByPrimaryKeySelective(completeOrder);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteCompleteOrder(Integer id) {

        if(StringUtils.isBlank(id.toString())){
            throw new CompleteOrderIdIsNullException("传入的用户名为空");
        }

        completeOrderMapper.deleteByPrimaryKey(id);
    }
}
