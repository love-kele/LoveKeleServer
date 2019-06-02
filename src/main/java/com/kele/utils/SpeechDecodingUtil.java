package com.kele.utils;

import com.kele.context.Constants;
import org.bytedeco.javacpp.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 语音编码工具类
 */
public class SpeechDecodingUtil {

    private static final Logger logger = LoggerFactory.getLogger(SpeechDecodingUtil.class);

    public static String OtherToPcm(String path, String newpath) {


        Runtime run = Runtime.getRuntime();
        File file = null;
        Process exec = null;
        String command = Constants.FFmpegConfig.Command.getWavToPcm(path, newpath);
        try {
            logger.info(String.format("FFMPEG commmand = %s", command));
            exec = run.exec(command);
            //int i = exec.exitValue();
            //if (i == 0) {
              //  exec.getInputStream().close();
               // exec.getOutputStream().close();
               // exec.getErrorStream().close();
            Thread.sleep(2000);
                return newpath;
            //}

           // logger.info(String.format("转码后语音文件路径 = %s  ", newpath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                int bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                boolean var6 = false;

                int len;
                while (-1 != (len = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

    @Test
    public void test(){


        String path = "C:\\Users\\28574\\Downloads\\dgk_shooter_min.conv\\dgk_shooter_min.conv";


        try {

            FileReader fileReader = new FileReader(path);
            FileWriter fileWriter = new FileWriter("d:\\tmp\\dgk_utf8_min.conv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str=null;
            while (( str =bufferedReader.readLine())!=null){
                str.getBytes("utf-8");
                bufferedWriter.write(str+"\n\r");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }


    }

}
