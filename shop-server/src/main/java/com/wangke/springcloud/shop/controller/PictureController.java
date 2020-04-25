package com.wangke.springcloud.shop.controller;

import com.wangke.springcloud.shop.comm.ResultInfo;
import com.wangke_utils.File_Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("picture")
public class PictureController {
    @RequestMapping("upload")
    @ResponseBody
    public Object upload(MultipartFile file) throws IOException {
        String processFile = File_Utils.processFile(file);
        return  new ResultInfo().ok(processFile);
   }
}
