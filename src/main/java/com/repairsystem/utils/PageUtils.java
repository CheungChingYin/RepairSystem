package com.repairsystem.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author CheungChingYin
 * @date 2018/11/7
 * @time 12:12
 */
public class PageUtils {

    public static Map<String, Object> pageHandler(String page, String count) {

        Integer tempPage = Integer.parseInt(page);
        Integer tempCount = Integer.parseInt(count);
        Map<String, Object> map = new HashMap<String, Object>();

        Integer prePage = prePageHandler(tempPage);
        Integer nextPage = nextPageHandler(tempPage,tempCount);
        List<Integer> pageList = pageHandler(tempPage,tempCount);
        Integer pages = pagesCount(tempCount);

        map.put("page",page);
        map.put("prePage",prePage);
        map.put("nextPage",nextPage);
        map.put("pages",pages);
        map.put("count",tempCount);
        map.put("pageList",pageList);
        return map;
    }

    /**
     * 上一页逻辑
     * @param page
     * @return
     */
    public static Integer prePageHandler(Integer page) {

        Integer prePage;
        if (page - 1 == 0) {
            prePage = 1;
        } else {
            prePage = page - 1;
        }
        return prePage;
    }

    /**
     * 下一页逻辑
     * @param page
     * @param count
     * @return
     */
    public static Integer nextPageHandler(Integer page, Integer count) {

        Integer PAGESIZE = ConstantUtils.Page.PAGESIZE;
        Integer pages = pagesCount(count);
        Integer nextPage;
        if (page == pages) {
            nextPage = pages;
        } else {
            nextPage = page + 1;
        }
        return nextPage;
    }

    /**
     * 展示出来的页码数
     * @param page
     * @param count
     * @return
     */
    public static List<Integer> pageHandler(Integer page,Integer count){

        List<Integer> list = new LinkedList<Integer>();
        Integer PAGENUM = ConstantUtils.Page.PAGESNUM;

        Integer pages = pagesCount(count);
        Integer minPages = (page - PAGENUM > 0) ? (page - PAGENUM) : (1);//和上一页同理
        Integer maxPages = (page + PAGENUM >= pages)?(pages):(page + PAGENUM);//与下一页同理

        for(int i = minPages;i<= maxPages;i++){
            list.add(i);//添加最小页到最大页之间的页码
        }
        return list;
    }

    /**
     * 页数总数
     * @param count
     * @return
     */
    public static Integer pagesCount(Integer count) {
        Integer PAGESIZE = ConstantUtils.Page.PAGESIZE;
        Integer pages = (count % PAGESIZE == 0) ? (count / PAGESIZE) : (count / PAGESIZE + 1);
        return pages;
    }

}
