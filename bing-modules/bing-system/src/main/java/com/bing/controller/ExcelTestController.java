package com.bing.controller;


import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.bing.domain.R;
import com.bing.entity.User;
import com.bing.entity.UserInfo;
import com.bing.utils.ExcelGenerator;
import com.bing.utils.JAVAMail;
import com.bing.utils.poi.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("excel")
@Slf4j
public class ExcelTestController {

    @Autowired
    private JAVAMail javaMail;

    @PostMapping("/test")
    public R<Object> register() throws Exception {
        UserInfo userInfo = new UserInfo();
        List<UserInfo> userInfos = new ArrayList<>();
        userInfo.setNickName("zhangsan");
        userInfo.setIdNumber("1321321321");
        userInfos.add(userInfo);
        ByteArrayInputStream byteArrayInputStream = ExcelGenerator.generateExcel(userInfos);
        /**
         * 发送带附件的邮件
         * @param receiver 发件人
         * @param title 主题
         * @param content 邮件内容
         * @param fileName 附件名
         * @param inputstream 附件流
         * @throws Exception
         */
        log.info("开始发送邮件");
        javaMail.sendEmail("13849954285@163.com","测试收件人","主题内容","文件名称.xlsx",byteArrayInputStream);
        log.info("发送成功");
        return R.ok(Boolean.TRUE);
    }
}
