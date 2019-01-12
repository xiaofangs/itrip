package cn.itrip.auth.service.impl;

import cn.itrip.auth.service.TokenService;
import cn.itrip.common.RedisAPI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    private RedisAPI redisAPI;
    @Override
    public String generateToken() {
        return null;
    }

    @Override
    public void save() {

    }
}
