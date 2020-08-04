package com.example.seed.controller;

import com.example.seed.support.utils.EmptyUtil;
import com.example.seed.support.utils.verifyCode.IVerifyCodeGen;
import com.example.seed.support.utils.verifyCode.SimpleCharVerifyCodeGenImpl;
import com.example.seed.support.utils.verifyCode.VerifyCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/1 9:26
 */
@Slf4j
@RestController
@RequestMapping("/verifyCode")
@Api(tags = "验证码管理 VerifyCodeController")
public class VerifyCodeController {
    @ApiOperation(value = "验证码")
    @GetMapping("/get")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(120, 28);
            String code = verifyCode.getCode();
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("KAPTCHA_SESSION_KEY", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }
    }

    @ApiOperation(value = "验证验证码")
    @GetMapping("/checkCode")
    public String checkCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        String codeObj = "错误";
        try {
            codeObj = request.getSession().getAttribute("KAPTCHA_SESSION_KEY") + "";
        } catch (Exception e) {
            log.info("", e);
        }
        return codeObj;
    }

    @ApiOperation("生产验证码image")
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        log.info("获取验证码");
        ServletOutputStream out = null;
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();

            response.setDateHeader("Expires", 0);
            // Set standard HTTP/1.1 no-cache headers.
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            // Set standard HTTP/1.0 no-cache header.
            response.setHeader("Pragma", "no-cache");
            // return a jpeg
            response.setContentType("image/jpeg");
            // create the text for the image
            // store the text in the session
            request.getSession().setAttribute("KAPTCHA_SESSION_KEY", code);
            // create the image with the text
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
            System.out.println("******************验证码是: " + code + "******************");
        } catch (IOException e) {
            log.error("generate captcha image error: {}", e.getMessage());
        }
    }
}
