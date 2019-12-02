package com.example.main.htcf;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.Result;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;

/**
 * 调用kettle任务工具类
 *
 * @author linjinyuan
 * @date 2017-11-20 下午4:09:39
 */
public class CallKettleTaskUtils {

    public static Result runJob(String path) throws KettleException {

        KettleEnvironment.init();

        JobMeta jobMeta = new JobMeta(path, null);
        Job job = new Job(null, jobMeta);
        job.start();
        job.waitUntilFinished();

//        job.setParameterValue(key, value);
//        job.setVariable(key, value);

        if (job.getErrors() > 0) {
            throw new KettleException("There are errors during job exception!(执行job发生异常)");
        }

        Result result = job.getResult();
        return result;
    }

}
