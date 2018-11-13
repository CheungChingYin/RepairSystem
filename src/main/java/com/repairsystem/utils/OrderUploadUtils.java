package com.repairsystem.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author CheungChingYin
 * @date 2018/11/13
 * @time 10:40
 */
@Component
public class OrderUploadUtils {


    private static String dir = ConstantUtils.Path.DIRPATH;

    public static Map<String, String> upLoadOrderImage(MultipartFile file, String userName) {
        Map<String, String> resultMap = new HashMap<String, String>();
        if (file.isEmpty()) {
            resultMap.put("failure", "传入的文件为空");
            return resultMap;
        }
        SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = simpleDateFormatDate.format(new Date());

        String fileName = file.getOriginalFilename();
        String realPath = dir + "/" + currentDate + "/";
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        String extName = FilenameUtils.getExtension(fileName);
        String allowImgFormat = "gif,jpg,jpeg,png";

        if (!allowImgFormat.contains(extName.toLowerCase())) {
            resultMap.put("failure", "传入的文件不是图像");
            return resultMap;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd&HH-mm-ss");
        String currentTime = simpleDateFormat.format(new Date());
        fileName = currentTime + userName + UUID.randomUUID() + ".jpg";
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = file.getInputStream();
            fileOutputStream = new FileOutputStream(realPath + fileName);
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (IOException e) {
            resultMap.put("failure", "图片储存失败");
            e.printStackTrace();
            return resultMap;
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        }
        resultMap.put("success", "/" + currentDate + "/" + fileName);
        return resultMap;
    }
}
