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
    public static class OrderStatus {

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

    public static class Page {

        //一页展示多少条
        public static final Integer PAGESIZE = 10;

        //页码展示数量
        public static final Integer PAGESNUM = 4;
    }

    class Path {

        //虚拟目录地址
        public static final String DIRPATH = "E:/Images";

        public static final String QRCODEPATH = "/QRCODE";

    }

    class Cookie {

        /**
         * Cookie最长存活时间(单位：秒)
         */
        public static final int COOKIE_MAX_TIME = 3 * 24 * 3600;
    }

//    class Redis{
//
//        public static final long REDIS_MAX_TIME = 3*24*3600;
//    }

    class Mail {
        public static final String FROM_MAIL = "FSPT_RepairManagement@outlook.com";
    }

    class WebSocket {
        /**
         * WebSocket广播前缀
         */
        public static final String BROADCAST_PREFIX = "/topic";

        /**
         * WebSocket点对点前缀
         */
        public static final String PEER_TO_PEER_PREFIX = "/queue";

        /**
         * 接收到新工单WebSocket订阅队列
         */
        public static final String RECEIVE_ORDER_TOPIC = "/receiveOrder";

        /**
         * 接受新工单后的提示
         */
        public static final String RECEIVE_ORDER_MESSAGE = "您有一张新工单，请及时查收";


    }
}
