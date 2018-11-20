package com.repairsystem.web.controller;

import com.google.zxing.qrcode.encoder.QRCode;
import com.repairsystem.entity.Class;
import com.repairsystem.utils.QRCodeUtils;
import com.repairsystem.utils.ZipUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author CheungChingYin
 * @date 2018/11/19
 * @time 20:10
 */
@Controller
@Api(value = "二维码相关接口", tags = {"二维码相关接口"})
@RequestMapping("/QRCode")
public class QRCodeController {

    @ApiOperation(value = "下载二维码图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "domain", value = "当前域名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "buildingId", value = "所属实训楼Id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "buildingName", value = "所属实训楼名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "classId", value = "所属实训室ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "className", value = "所属实训室名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "computerStartNum", value = "电脑开始编号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "computerEndNum", value = "电脑结束编号", required = true, dataType = "String", paramType = "query"),

    })
    @GetMapping("/QRCodeDownLoad")
    public String downloadQRCode(String domain, Integer buildingId, String buildingName, Integer classId, String className,
                                 Integer computerStartNum, Integer computerEndNum, HttpServletResponse response) {
        Class clazz = new Class();
        clazz.setBuildingId(buildingId);
        clazz.setBuildingName(buildingName);
        clazz.setClassId(classId);
        clazz.setClassName(className);

        String dirPath = QRCodeUtils.generateQRCode(domain, clazz, computerStartNum, computerEndNum);
        String zipFileName = buildingName + "&" + className + ".zip";
        String zipFilePath = dirPath + zipFileName;
        boolean zipResult = ZipUtils.singleFileCompress(dirPath, zipFilePath, null);
        if (zipResult) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=QRCode.zip");// 设置文件名
            File file = new File(zipFilePath);
            if (file.exists()) {

                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    IOUtils.copy(fis, response.getOutputStream());
                    response.flushBuffer();
                    System.out.println("success");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }
        return null;
    }

}
