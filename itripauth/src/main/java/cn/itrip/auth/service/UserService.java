package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;

public interface UserService {
    public void itriptxCreateByPhone(ItripUser itripusers);
    public boolean validateByPhone(String phoneNum,String code);
    public ItripUser SelectByUserCode(String userCode);
    public void ItriptxCreateUser(ItripUser user);
    public boolean activate(String mail,String code);
}
