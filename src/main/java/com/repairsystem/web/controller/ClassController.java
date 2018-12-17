package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.repairsystem.entity.Class;
import com.repairsystem.entity.vo.ClassVO;
import com.repairsystem.service.ClassService;
import com.repairsystem.utils.ConstantUtils;
import com.repairsystem.utils.Entity2VO;
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
 * @date 2018/11/12
 * @time 9:47
 */
@RestController
@Api(value = "实训室业务相关接口", tags = {"实训室业务相关接口"})
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @ApiOperation(value = "获得所有实训室信息")
    @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAllClassInfo")
    public JsonResult getAllClassInfo(String page) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Class> classList = classService.searchAllClass();

        List<ClassVO> voList = Entity2VO.entityList2VOList(classList, ClassVO.class);

        Integer count = classService.getClassCount();
        Map<String, Object> pageMap = PageUtils.pageHandler(page, count.toString());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", voList);
        return JsonResult.ok(resultMap);

    }

    @ApiOperation(value = "通过实训室ID获得实训室信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "实训室ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getClassInfoById")
    public JsonResult getClassInfoById(String page, Integer classId) {

        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页不能为空");
        }
        if (StringUtils.isBlank(classId.toString())) {
            return JsonResult.errorMsg("传入的实训室Id(classId)不能为空");
        }

        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        Class clazz = classService.searchClassById(classId);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, "1");

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", clazz);

        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过实训室名称获得实训室和信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "className", value = "实训室名称", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getClassInfoByName")
    public JsonResult getClassInfoByName(String page, String className) {

        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页不能为空");
        }
        if (StringUtils.isBlank(className)) {
            return JsonResult.errorMsg("传入的实训室名称(className)不能为空");
        }

        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Class> listClass = classService.searchClassByName(className);
        List<ClassVO> listVO = Entity2VO.entityList2VOList(listClass, ClassVO.class);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, listVO.size() + "");

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", listVO);

        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过实训楼ID获得实训室信息")
    @ApiImplicitParam(name = "buildingId", value = "实训室ID", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getClassInfoByBuildingId")
    public JsonResult getClassInfoByBuildingId(String buildingId){
        if (StringUtils.isBlank(buildingId)){
            return JsonResult.errorMsg("传入的实训楼Id不能为空!");
        }
        List<Class> listClass = classService.searchClassByBuildingId(buildingId);
        List<ClassVO> listVO = Entity2VO.entityList2VOList(listClass,ClassVO.class);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("Info", listVO);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation("保存班级信息")
    @PostMapping("/saveClassInfo")
    public JsonResult saveClassInfo(@RequestBody Class clazz) {
        classService.saveClass(clazz);
        return JsonResult.ok();
    }

    @ApiOperation("修改班级信息")
    @PostMapping("/updateClassInfo")
    public JsonResult updateClassInfo(@RequestBody Class clazz) {
        if (StringUtils.isBlank(clazz.getClassId().toString())) {
            return JsonResult.errorMsg("传入的班级ID(classId)不能为空");
        }
        classService.updateClass(clazz);
        return JsonResult.ok();
    }

    @ApiOperation("删除班级信息")
    @ApiImplicitParam(name = "classId", value = "实训室ID", required = true, dataType = "String", paramType = "query")
    @GetMapping("/deleteClassInfo")
    public JsonResult deleteClassInfo(Integer classId) {
        if (StringUtils.isBlank(classId.toString())) {
            return JsonResult.errorMsg("传入的班级ID(classId)不能为空");
        }
        try {
            classService.deleteClass(classId);
        }catch (MySQLIntegrityConstraintViolationException e){
            return JsonResult.errorException("由于班级信息和工单绑定,请删除和当前班级相关工单后再进行删除");
        }
        return JsonResult.ok();
    }
}
