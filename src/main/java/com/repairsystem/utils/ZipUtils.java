package com.repairsystem.utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * 压缩包工具类
 *
 * @author CheungChingYin
 * @date 2018/11/19
 * @time 14:23
 */
public class ZipUtils {

    //声明压缩对象
    private static ZipParameters parameters;

    //解压文件对象
    private static ZipFile zipFile;

    /**
     * @param sourceFilePath 被压缩的文件的路径(单文件,文件夹)
     * @param zipFilePath    压缩文件路径
     * @param password       压缩密码
     * @return 压缩成功：true ，压缩失败：false
     */
    public static Boolean singleFileCompress(String sourceFilePath, String zipFilePath, String password) {
        parameters = new ZipParameters();
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // 压缩方式(默认方式)
        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL); // 压缩级别(默认级别)
        //压缩加密设置
        if (!StringUtils.isEmpty(password)) {
            parameters.setEncryptFiles(true);//是否设置文件加密(默认为否)
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD); // 加密方式(此处是标准压缩)
            parameters.setPassword(password.toCharArray());
        }
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            //如果是文件则直接压缩，若是文件夹，遍历文件全部压缩
            if (new File(sourceFilePath).isFile()) {
                zipFile.setFileNameCharset("GBK");
                zipFile.addFile(new File(sourceFilePath), parameters);
                return true;
            }
            //File ff=new File(sourceFilePath);
            File[] flst = new File(sourceFilePath).listFiles();
            System.out.println("文件个数=>" + flst.length);
            for (File f : flst) {
                zipFile.setFileNameCharset("GBK");
                zipFile.addFile(f, parameters);
            }

            return true;
        } catch (ZipException e) {
            e.printStackTrace();
            return false;
        } catch (Exception id) {
            id.printStackTrace();
            return false;
        }
    }

    public static Boolean unZip(String zipFile, String unZipDir) {
        try {
            ZipUtils.zipFile = new ZipFile(zipFile);
            ZipUtils.zipFile.setFileNameCharset("GBK");//设置编码格式
            //用自带的方法检测一下zip文件是否合法，包括文件是否存在、是否为zip文件、是否被损坏等
            if (!ZipUtils.zipFile.isValidZipFile()) {
                throw new ZipException("文件不合法或不存在");
            }
            // 跟java自带相比，这里文件路径会自动生成，不用判断
            ZipUtils.zipFile.extractAll(unZipDir);
            return true;
        } catch (ZipException e) {
            return false;
        }
    }
}
