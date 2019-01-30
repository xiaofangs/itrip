package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.MailService;
import cn.itrip.auth.service.SmsService;
import cn.itrip.auth.service.UserService;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.MD5;
import cn.itrip.common.RedisAPI;
import cn.itrip.dao.user.ItripUserMapper;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("UserService")

public class UserServiceImpl implements UserService{
    @Resource
    private ItripUserMapper itripUserMapper;
    @Resource
    private SmsService smsService;
    @Resource
    private RedisAPI redisAPI;
    @Resource
    private MailService mailService;

    public void itriptxCreateByPhone(ItripUser itripusers){
        try {
            itripUserMapper.insertItripUser(itripusers);
            int code= MD5.getRandomCode();
             smsService.send(itripusers.getUserCode(),"1",new String[]{String.valueOf(code),"1"});
             redisAPI.set("activation:"+itripusers.getUserCode(),60,String.valueOf(code));
        }catch (Exception e){
            e.printStackTrace();
        }


    }



    public ItripUser SelectByUserCode(String userCode){
        ItripUser user=null;
        try {
            user=itripUserMapper.getItripUserByUserCode(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void ItriptxCreateUser(ItripUser user) {
        try {
            itripUserMapper.insertItripUser(user);
            String activationCode= MD5.getMd5(new Date().toLocaleString(),32);
            mailService.sendActivationMail(user.getUserCode(),activationCode);
            redisAPI.set("activation:"+user.getUserCode(),30*60,activationCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean activate(String mail, String code) {
        String key="activation:"+mail;
        String value=redisAPI.get(key);
        if(value.equals(code)&&value!=null){
            ItripUser user=this.SelectByUserCode(mail);
            if(user!= null){
                user.setActivated(1);
                user.setFlatID(user.getId());
                user.setUserType(0);
                try {
                    itripUserMapper.updateItripUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return  false;
    }

    @Override
    public ItripUser login(String userCode, String userPass) throws Exception{
        ItripUser user=null;
        try {
            user=itripUserMapper.getItripUserByUserCode(userCode);
            if(user!=null){
                 if(user.getUserPassword().equals(userPass)){
                     if(user.getActivated()!=1) {
                         user = null;
                         throw new Exception("用户未激活");
                     }
                     return user;
                 }else{
                     user = null;
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public boolean validateByPhone(String phoneNum,String code){
        String key="activation:"+phoneNum;
        String value=redisAPI.get(key);
        if(value.equals(code)&&value!=null){
            ItripUser user=this.SelectByUserCode(phoneNum);
            if(user!= null){
                 user.setActivated(1);
                 user.setFlatID(user.getId());
                 user.setUserType(0);
                try {
                    itripUserMapper.updateItripUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
               return true;
            }
        }
     return  false;
    }


}
