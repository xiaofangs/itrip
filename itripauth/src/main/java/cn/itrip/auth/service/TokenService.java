package cn.itrip.auth.service;

import cn.itrip.beans.pojo.ItripUser;

public interface TokenService {
    public String generateToken(String userAgent, ItripUser user);
    public void save(String token,ItripUser user);
    public boolean validate(String token,String agent);
    public void delete(String token);
    public String toloadToken(String agent,String token) throws  Exception;

}
