package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.SmsService;
import cn.itrip.beans.pojo.ItripUser;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("SmsService")
public class SmsServiceImpl implements SmsService{
    public void send(String to,String templateId,String[] datas){
        CCPRestSmsSDK sdk=new CCPRestSmsSDK();
        sdk.init("app.cloopen.com","8883");
        sdk.setAccount("8a216da8681259360168212fe8ab0679","01bf71973af2439ba6ed00190795501c");
        sdk.setAppId("8a216da8681259360168212fe8f5067f");
        HashMap map=sdk.sendTemplateSMS(to,templateId,datas);
        if("000000".equals(map.get("statusCode"))){
            System.out.println("短线发送成功");
        }else{
            new Exception(map.get("statusCode").toString()+map.get("statusMsg").toString());
        }
    }
}
