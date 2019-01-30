package cn.itrip.test;
import cn.itrip.common.DateUtil;
import cn.itrip.service.hoteltempstore.ItripHotelTempStoreService;

import java.util.HashMap;
import java.util.Map;

public class ThreadDemo extends Thread {

    private String threadNo;


    private  ItripHotelTempStoreService hotelTempStoreService;


    public ThreadDemo(String _threadNo,ItripHotelTempStoreService _hotelTempStoreService) {
        threadNo = _threadNo;
        hotelTempStoreService = _hotelTempStoreService;

    }


    @Override
    public void run() {//线程开始执行
        super.run();
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            param.put("startTime", DateUtil.parse("2018-09-01", "yyyy-MM-dd"));
            param.put("endTime", DateUtil.parse("2018-09-10", "yyyy-MM-dd"));
            param.put("roomId", 1);
            param.put("hotelId", 1);
            param.put("count", 10);
            hotelTempStoreService.validateRoomStore(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("run ================ threadNo:" + threadNo);
    }


    public String getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(String threadNo) {
        this.threadNo = threadNo;
    }

}