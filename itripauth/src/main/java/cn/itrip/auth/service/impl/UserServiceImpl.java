package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.SmsService;
import cn.itrip.auth.service.UserService;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.MD5;
import cn.itrip.dao.user.ItripUserMapper;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserService")

public class UserServiceImpl implements UserService{
   @Resource
    private ItripUserMapper itripUserMapper;
    @Resource
    private SmsService smsService;

    public void itriptxCreateByPhone(ItripUser itripusers){
        try {
            itripUserMapper.insertItripUser(itripusers);
            int code= MD5.getRandomCode();
             smsService.send(itripusers.getUserCode(),"1",new String[]{String.valueOf(code),"1"});
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
