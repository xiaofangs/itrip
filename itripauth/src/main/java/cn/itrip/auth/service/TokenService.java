package cn.itrip.auth.service;

public interface TokenService {
    public String generateToken();
    public void save();

}
