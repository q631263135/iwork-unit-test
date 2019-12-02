package com.example.main.htcf;

import java.io.File;
import org.pentaho.di.core.exception.KettleException;
import org.springframework.util.StringUtils;

public class KettlePushServiceImpl {

    public void pushKettleJob(String path) throws KettleException {

        if (StringUtils.isEmpty(path)) {
            throw new RuntimeException("执行kettle任务失败，kettle 文件路径为空");
        }

        if (!path.endsWith(".kjb")) {
            throw new RuntimeException("执行kettle任务失败，kettle 文件格式有误");
        }

        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("执行kettle任务失败，kettle 文件不存在：" + path);
        }

        CallKettleTaskUtils.runJob(path);
    }

}
