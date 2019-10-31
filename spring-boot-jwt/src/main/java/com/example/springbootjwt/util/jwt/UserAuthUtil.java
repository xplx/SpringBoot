package com.example.springbootjwt.util.jwt;


import com.example.springbootjwt.support.config.KeyConfiguration;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by ace on 2017/9/15.
 */
@Configuration
public class UserAuthUtil {
    @Autowired
    private KeyConfiguration keyConfiguration;


    public IJWTInfo getInfoFromToken(String token) throws Exception {
        try {
            return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
        }catch (ExpiredJwtException ex){
            throw new RuntimeException("User token expired!");
        }catch (SignatureException ex){
            throw new RuntimeException("User token signature error!");
        }catch (IllegalArgumentException ex){
            throw new RuntimeException("User token is null or empty!");
        }
    }
}
