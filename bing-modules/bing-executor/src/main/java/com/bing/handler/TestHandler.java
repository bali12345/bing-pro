package com.bing.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

@Component
@Slf4j
public class TestHandler {

    @XxlJob("testHandler")
    public ReturnT<String> testHandler() {
        log.info("测试定时任务执行");
        return SUCCESS;
    }

    @XxlJob("testHandlerStr")
    public ReturnT<String> testHandlerStr() {
        String jobParam = XxlJobHelper.getJobParam();
        log.info("测试带参数的定时任务{}",jobParam);
        return SUCCESS;
    }

}
