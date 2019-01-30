package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.TokenService;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.MD5;
import cn.itrip.common.RedisAPI;
import cn.itrip.common.UserAgentUtil;
import com.alibaba.fastjson.JSON;
import javafx.beans.binding.StringBinding;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    private int delay=2*60;
    private long protectedTime=30*60;
    @Override
    public String toloadToken(String agent, String token) throws Exception{
          if(!redisAPI.exist(token)){
                throw new  Exception("token无效");
          }
          Date genTime=new SimpleDateFormat("yyyyMMddHHmmss").parse(token.split("-")[3]);
          long passed= Calendar.getInstance().getTimeInMillis()-genTime.getTime();
          if(passed<protectedTime*1000){
              throw  new Exception("token保护期内不能置换，剩余时间"+(protectedTime-passed)/1000);

          }
          String user=redisAPI.get(token);
          ItripUser itripUser=JSON.parseObject(user,ItripUser.class);
          String   newToken=this.generateToken(agent,itripUser);
         redisAPI.set(token ,delay,user);
         this.save(newToken,itripUser);
        return newToken;
    }

    @Override
    public boolean validate(String token, String agent) {
        if(!redisAPI.exist(token)){
            return false;
        }
        String md5Agent=token.split("-")[4];
        if (!MD5.getMd5(agent,6).equals(md5Agent)){
            return false;
        }
        return true;
    }

    @Override
    public void delete(String token) {
        redisAPI.delete(token);
    }

    @Resource
    private RedisAPI redisAPI;
    @Override
    public String generateToken(String userAgent, ItripUser user) {
        StringBuilder sb=new StringBuilder();
        sb.append("token:");
        UserAgent agent= UserAgent.parseUserAgentString(userAgent);
        if(agent.getOperatingSystem().isMobileDevice()){
            sb.append("MOBILE-");
        }else{
            sb.append("PC-");
        }
        sb.append(MD5.getMd5(user.getUserCode(),32)+"-");
        sb.append(user.getId().toString()+"-");
        sb.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"-");
       sb.append(MD5.getMd5(userAgent,6));
        return sb.toString();
    }

    @Override
    public void save(String token,ItripUser user) {
        if(token.startsWith("token:PC-")){
           redisAPI.set(token,2*60*60, JSON.toJSONString(user));
        }else{
            redisAPI.set(token,JSON.toJSONString(user));
        }
    }
}
