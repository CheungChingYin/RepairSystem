package com.repairsystem.utils;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 15:25
 */
public interface ConstantUtils {

    /**
     * 维修单状态码
     */
    public static class OrderStatus{

        /**
         * 未维修状态码：0
         */
        public static final Integer NOTREPAIRED = 0;

        /**
         * 维修中状态码：1
         */
        public static final Integer REPAIRING = 1;

        /**
         * 维修完成状态码：2
         */
        public static final Integer REPAIRED = 2;
    }
}
