package cn.itrip.service.hoteltempstore;
import cn.itrip.beans.pojo.ItripHotelTempStore;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.vo.store.StoreVO;
import cn.itrip.common.Page;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelTempStoreService {

    public ItripHotelTempStore getItripHotelTempStoreById(Long id)throws Exception;

    public List<ItripHotelTempStore> getItripHotelTempStoreListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelTempStoreCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception;

    public Integer itriptxModifyItripHotelTempStore(ItripHotelTempStore itripHotelTempStore)throws Exception;

    public Integer itriptxDeleteItripHotelTempStoreById(Long id)throws Exception;

    public Page<ItripHotelTempStore> queryItripHotelTempStorePageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    /***
     * startTime 开始时间
     * endTime 结束时间
     * roomId 房间ID
     * hotelId 酒店ID
     * @return
     * @throws Exception
     */
    public List<StoreVO> queryRoomStore(Map<String, Object> param)throws Exception;
    /***
     * startTime 开始时间
     * endTime 结束时间
     * roomId 房间ID
     * hotelId 酒店ID
     * count 预订数目
     * @return
     * @throws Exception
     */
    public boolean validateRoomStore(Map<String, Object> param)throws Exception;
    /***
     * startTime 开始时间
     * endTime 结束时间
     * roomId 房间ID
     * count 预订数目
     * @return
     * @throws Exception
     */
    public boolean updateRoomStore(Map<String, Object> param) throws Exception;
}
