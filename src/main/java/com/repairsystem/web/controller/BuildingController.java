package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.entity.Building;
import com.repairsystem.service.BuildingService;
import com.repairsystem.utils.ConstantUtils;
import com.repairsystem.utils.JsonResult;
import com.repairsystem.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CheungChingYin
 * @date 2018/11/11
 * @time 21:44
 */
@RestController
@Api(value = "实训楼业务相关接口", tags = {"实训楼业务相关接口"})
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @ApiOperation(value = "获得全部实训楼信息")
    @GetMapping("/getBuildingInfo")
    public JsonResult getBuildingInfo(){
        List<Building> list = buildingService.searchAllBuilding();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("Info", list);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "获得十条实训楼信息")
    @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAllBuildingInfo")
    public JsonResult getAllBuildingInfo(String page) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Building> list = buildingService.searchAllBuilding();

        Integer count = buildingService.getBuildingCount();
        Map<String, Object> pageMap = PageUtils.pageHandler(page, count.toString());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", list);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过实训楼ID获得实训楼信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "buildingId", value = "实训楼ID", required = true, dataType = "String", paramType = "query")

    })
    @GetMapping("/getBuildingInfoById")
    public JsonResult getBuildingInfoById(String page, Integer buildingId) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页page参数不能为空");
        }
        if (StringUtils.isBlank(buildingId.toString())) {
            return JsonResult.errorMsg("传入实训楼ID参数不能为空");
        }

        Map<String, Object> pageMap = PageUtils.pageHandler(page, "1");

        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        Building building = buildingService.searchBuildingById(buildingId);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", building);

        return JsonResult.ok(resultMap);

    }

    @ApiOperation(value = "通过实训楼名称获得实训楼信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "buildingName", value = "实训楼名称", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getBuildingInfoByName")
    public JsonResult getBuildingInfoByName(String page,String buildingName){
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页page参数不能为空");
        }
        if (StringUtils.isBlank(buildingName)) {
            return JsonResult.errorMsg("传入实训楼名称buildingName参数不能为空");
        }

        PageHelper.startPage(Integer.parseInt(page),ConstantUtils.Page.PAGESIZE);
        List<Building> list = buildingService.searchBuildingByName(buildingName);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, list.size()+"");

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", list);

        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "保存实训楼信息")
    @PostMapping("/saveBuildingInfo")
    public JsonResult saveBuildingInfo(@RequestBody Building building){
        buildingService.savBuilding(building);
        return JsonResult.ok();
    }

    @ApiOperation(value = "修改实训楼信息")
    @PostMapping("/updateBuildingInfo")
    public JsonResult updateBuildingInfo(@RequestBody Building building){
        buildingService.updateBuilding(building);
        return JsonResult.ok();
    }

    @ApiOperation("删除实训楼信息")
    @ApiImplicitParam(name = "buildingId", value = "实训楼ID", required = true, dataType = "String", paramType = "query")
    @GetMapping("/deleteBuildingInfo")
    public JsonResult deleteBuildingInfo(Integer buildingId){
        buildingService.deleteBuilding(buildingId);
        return JsonResult.ok();
    }
}

