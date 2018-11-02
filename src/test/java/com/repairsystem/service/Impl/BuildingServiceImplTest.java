package com.repairsystem.service.Impl;

import com.repairsystem.RepairsystemApplication;
import com.repairsystem.entity.Building;
import com.repairsystem.service.BuildingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 10:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepairsystemApplication.class)
public class BuildingServiceImplTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    public void searchAllBuilding() {
        List<Building> list = buildingService.searchAllBuilding();
        for (Building building : list){
            System.out.println(building.getBuildingName());
        }
    }

    @Test
    public void searchBuildingById() {
        Building building = buildingService.searchBuildingById(4);
        System.out.println(building.getBuildingName());
    }

    @Test
    public void searchBuildingByName() {
        List<Building> list = buildingService.searchBuildingByName("实训楼");
        for(Building building : list){
            System.out.println(building.getBuildingName());
        }
    }

    @Test
    public void savBuilding() {
        Building building = new Building();
        building.setBuildingName("实训楼D");
        buildingService.savBuilding(building);
    }

    @Test
    public void updateBuilding() {
        Building building = new Building();
        building.setBuildingId(4);
        building.setBuildingName("教学楼A");
        buildingService.updateBuilding(building);
    }

    @Test
    public void deleteBuilding() {
        buildingService.deleteBuilding(4);
    }
}