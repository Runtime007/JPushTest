package bat.bin.com.myapplication3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import android.os.Environment;
import android.util.Log;

/**
 * 日志打印 Created by Administrator on 2015/6/10.
 */
public class LogUtil {
    
    /**
     * 打印警告
     * 
     * @param tag
     *            标记
     * @param log
     *            日志
     */
    public static void i(String tag, Object log) {
        if (BuildConfig.DEBUG)
            Log.i(String.format("---------- %s ----------", tag),
                  String.valueOf(log));
    }
    
    /**
     * 打印错误或者异常
     * 
     * @param tag
     *            标记
     * @param log
     *            日志
     */
    public static void e(String tag, String log) {
        if (BuildConfig.DEBUG)
            Log.e(tag, log);
    }
    
    /**
     * 打印到文件
     * 
     * @param tag
     *            标记
     * @param log
     *            日志
     */
    public static void iFile(String tag, Object log) {
        File fileDir;
        // 判断sd卡是否存在
        boolean isSDExist = Environment.getExternalStorageState()
                                       .equals(Environment.MEDIA_MOUNTED);
        if (isSDExist) {
            // 获取跟目录
            fileDir = new File(Environment.getExternalStorageDirectory(),
                               String.format("%s/%s", "SaharaLog", "gps.txt"));
            if (!fileDir.exists())
                try {
                    File file = fileDir.getParentFile();
                    // 判断文件夹是否存在
                    if (!file.mkdir())
                                       // 不存在创建
                                       file.mkdir();
                    // 创建文件
                    fileDir.createNewFile();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(fileDir, true);
                outputStream.write(String.format("---------- %s ----------          %s\n",
                                                 tag,
                                                 log)
                                         .getBytes());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
    }
    
}
