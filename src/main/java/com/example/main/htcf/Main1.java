package com.example.main.htcf;

import java.io.File;
import java.io.FileNotFoundException;
import org.pentaho.di.core.exception.KettleException;
import org.springframework.util.ResourceUtils;

/**
 * <br/>
 *
 * @author yangchaozheng
 * @date 2019/12/13 10:32
 */
public class Main1 {

    public static void main(String[] args) {
        KettlePushServiceImpl kettlePushService = new KettlePushServiceImpl();
        try {
//            File kettleJob = ResourceUtils.getFile("C:\\Users\\joyin\\Desktop\\估值导入作业.kjb");
//            File kettleJob = ResourceUtils.getFile("classpath:htcf/估值导入作业.kjb");
            File kettleJob = ResourceUtils.getFile("/htcf/估值导入作业.kjb");
            System.out.println(kettleJob.getPath());
            kettlePushService.pushKettleJob(kettleJob.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (KettleException e) {
//            e.printStackTrace();
        }
    }

}
