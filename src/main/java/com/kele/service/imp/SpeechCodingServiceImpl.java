package com.kele.service.imp;

import com.kele.context.Constants;
import com.kele.service.SpeechCodingService;
import com.kele.utils.SpeechDecodingUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * 语音编码服务
 */
@Service
public class SpeechCodingServiceImpl implements SpeechCodingService {

    private static final Logger logger = LoggerFactory.getLogger(SpeechCodingServiceImpl.class);

    @Override
    public String getPcmSpeech(File multipartFile) {

        String path = multipartFile.getAbsolutePath();

        logger.info(String.format("请求语音文件路径 = %s ", path));
        String basefileName = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");


        String file = SpeechDecodingUtil.OtherToPcm(path,  getFilePath()+ "/" + basefileName + ".pcm");


        return  file;
    }

    private String getFilePath() {

        DateTime dateTime = new DateTime();
        String path = Constants.FFmpegConfig.DEV_BASE_PATH+dateTime.toString("YYYY/MM/dd") ;

        File file = new File(path);
        //如果目录不存在就创建目录
        if (!file.exists()) {
            file.mkdirs();
        }

        return path;
    }
}
