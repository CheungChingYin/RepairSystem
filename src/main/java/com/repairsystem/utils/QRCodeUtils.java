package com.repairsystem.utils;

import com.github.hui.quick.plugin.qrcode.wrapper.QrCodeGenWrapper;
import com.google.zxing.WriterException;
import com.repairsystem.entity.Class;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author CheungChingYin
 * @date 2018/11/18
 * @time 21:37
 */
public class QRCodeUtils {

    /**
     * @param domain
     * @param clazz
     * @param computerStartNum
     * @param computerEndNum
     * @return存储图片的文件夹地址
     */
    public static String generateQRCode(String domain, Class clazz, Integer computerStartNum, Integer computerEndNum) {
        if (computerStartNum.equals(computerEndNum)) {
            BufferedImage bufferedImage = null;
            try {
                bufferedImage = QrCodeGenWrapper.of("http://" + domain + "?buildingId=" + clazz.getBuildingId() + "&buildingName=" + clazz.getBuildingName() + "&classId=" + clazz.getClassId() + "&className=" + clazz.getClassName() + "&computerNum=" + computerStartNum)
                        .setW(300)
                        .setH(300)
                        .asBufferedImage();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriterException e) {
                e.printStackTrace();
            }
            BufferedImage picture = new BufferedImage(700, 300, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) picture.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 700, 300);
            g.drawImage(bufferedImage, 0, 0, null);
            g.setColor(Color.BLACK);
            g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            g.drawString("所在实训楼:" + clazz.getBuildingName(), 350, 50);
            g.drawString("所在实训室:" + clazz.getClassName(), 350, 100);
            g.drawString("电脑编号:" + computerStartNum, 350, 150);
            g.drawString("若当前电脑出现问题", 350, 200);
            g.drawString("请扫描左侧二维码进行报修", 350, 250);
            g.dispose();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = simpleDateFormat.format(new Date());
            String realPath = ConstantUtils.Path.DIRPATH + ConstantUtils.Path.QRCODEPATH + "/" + currentDate + "/" + UUID.randomUUID() + "/";
            String fileName = clazz.getBuildingName() + "-" + clazz.getClassName() + "-" + computerStartNum + ".jpg";

            File outPutFileDir = new File(realPath);
            if (!outPutFileDir.exists()) {
                outPutFileDir.mkdirs();
            }

            File outPutFile = new File(realPath + fileName);
            try {
                ImageIO.write(picture, "jpg", outPutFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return realPath;

        } else {
            BufferedImage bufferedImage = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = simpleDateFormat.format(new Date());
            String realPath = ConstantUtils.Path.DIRPATH + ConstantUtils.Path.QRCODEPATH + "/" + currentDate + "/" + UUID.randomUUID() + "/";

            File outPutFileDir = new File(realPath);
            if (!outPutFileDir.exists()) {
                outPutFileDir.mkdirs();
            }

            for (int i = computerStartNum; i <= computerEndNum; i++) {

                try {
                    bufferedImage = QrCodeGenWrapper.of("http://" + domain + "?buildingId=" + clazz.getBuildingId() + "&buildingName=" + clazz.getBuildingName() + "&classId=" + clazz.getClassId() + "&className=" + clazz.getClassName() + "&computerNum=" + i)
                            .setW(300)
                            .setH(300)
                            .asBufferedImage();
                    BufferedImage picture = new BufferedImage(700, 300, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g = (Graphics2D) picture.getGraphics();
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, 700, 300);
                    g.drawImage(bufferedImage, 0, 0, null);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
                    g.drawString("所在实训楼:" + clazz.getBuildingName(), 350, 50);
                    g.drawString("所在实训室:" + clazz.getClassName(), 350, 100);
                    g.drawString("电脑编号:" + i, 350, 150);
                    g.drawString("若当前电脑出现问题", 350, 200);
                    g.drawString("请扫描左侧二维码进行报修", 350, 250);
                    g.dispose();
                    String fileName = clazz.getBuildingName() + "-" + clazz.getClassName() + "-" + i + ".jpg";
                    File outPutFile = new File(realPath + fileName);
                    ImageIO.write(picture, "jpg", outPutFile);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
            return realPath;
        }
    }


}
