package com.repairsystem.service.Impl;

import com.repairsystem.RepairsystemApplication;
import com.repairsystem.dao.ClassMapper;
import com.repairsystem.entity.Class;
import com.repairsystem.entity.vo.ClassVO;
import com.repairsystem.service.ClassService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 14:53
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepairsystemApplication.class)
public class ClassServiceImplTest {

    @Autowired
    ClassService classService;

    @Test
    public void searchAllClass() {

        List<Class> list = classService.searchAllClass();
        for(Class classes:list){
            System.out.println(classes.toString());
        }
    }

    @Test
    public void searchClassById() {
        Class c = classService.searchClassById(2);
        System.out.println(c.toString());
    }

    @Test
    public void searchClassByName() {
        List<Class> list = classService.searchClassByName("B");
        for(Class c : list){
            System.out.println(c.toString());
        }
    }

    @Test
    public void saveClass() {
        Class classes = new Class();
        classes.setClassName("A303");
        classes.setComputerTotal(60);
        classes.setComputerEnable(49);
        classes.setComputerDisable(11);
        classes.setBuildingId(1);
        classService.saveClass(classes);
    }

    @Test
    public void updateClass() {
        Class c = new Class();
        c.setClassId(6);
        c.setClassName("A504");
        classService.updateClass(c);
    }

    @Test
    public void deleteClass() {
        classService.deleteClass(6);
    }

    @Test
    public void increaseComputerEnable(){
        classService.increaseComputerEnable(7);
    }

    @Test
    public void reduceCompleteEnable(){

        classService.reduceComputerEnable(7);
    }

    @Test
    public void testes(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd&HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        System.out.println(time);
    }
}