package com.repairsystem.dao;

import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.utils.MyMapper;

import java.util.List;

public interface CompleteOrderMapper extends MyMapper<CompleteOrder> {

    List<CompleteOrder> getAllCompleteOrder();

    CompleteOrder getCompleteOrderById(Integer id);

    Integer getCompleteOrderCount();

    List<CompleteOrder> getCompleteOrderByKeyWord(String keyWord);
}