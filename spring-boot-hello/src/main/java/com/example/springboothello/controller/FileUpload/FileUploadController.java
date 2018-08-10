package com.example.springboothello.controller.FileUpload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
// @TODO 服务器报错
@Controller
@RequestMapping("/upload")
public class FileUploadController {
    @PostMapping("/from")
    @ResponseBody
    public String handFromUpload(@RequestParam("name") String name,
                                 @RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getName();
            InputStream ins = file.getInputStream();
            //处理上传的内容
            return "success";
        }
        return "failure";
    }
}
