package com.example.springbootcache.service.serviceImpl;


import com.example.springbootcache.common.Constant;
import com.example.springbootcache.common.ResponseCode;
import com.example.springbootcache.common.ServerResponse;
import com.example.springbootcache.exception.ServiceException;
import com.example.springbootcache.service.TokenService;
import com.example.springbootcache.util.RandomUtil;
import com.example.springbootcache.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_NAME = "token";

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public ServerResponse createToken() {
        String str = RandomUtil.UUID32();
        StrBuilder token = new StrBuilder();
        token.append(Constant.Redis.TOKEN_PREFIX).append(str);

        redisUtil.set(token.toString(), token.toString(), Constant.Redis.EXPIRE_TIME_MINUTE);

        return ServerResponse.success(token.toString());
    }

    @Override
    public void checkToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_NAME);
        if (StringUtils.isBlank(token)) {// header中不存在token
            token = request.getParameter(TOKEN_NAME);
            if (StringUtils.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException(ResponseCode.ILLEGAL_ARGUMENT.getMsg());
            }
        }
        if (!redisUtil.exists(token)) {
            throw new ServiceException(ResponseCode.REPETITIVE_OPERATION.getMsg());
        }
        redisUtil.del(token);
    }

}
