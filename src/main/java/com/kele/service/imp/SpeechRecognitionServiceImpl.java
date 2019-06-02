package com.kele.service.imp;

import com.baidu.aip.util.Util;
import com.kele.enums.BackCode;
import com.kele.request.TalkRequest;
import com.kele.respone.RobotResponse;
import com.kele.robot.RobotService;
import com.kele.service.HanLpService;
import com.kele.service.SpeechCodingService;
import com.kele.service.SpeechRecognitionService;
import com.kele.speech.client.SpeechRecognitionClient;
import com.kele.request.AndroidRequest;
import com.kele.request.SpeechRequest;
import com.kele.respone.BaiduSdkResponse;
import com.kele.respone.BaseResponse;
import com.kele.utils.SpeechDecodingUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * 语音识别
 */
@Service
public class SpeechRecognitionServiceImpl implements SpeechRecognitionService {

    private static final Logger logger = LoggerFactory.getLogger(SpeechRecognitionServiceImpl.class);
    @Autowired
    private SpeechRecognitionClient speechRecognitionClient;

    @Autowired
    private HanLpService hanLpService;

    @Autowired
    private SpeechCodingService speechCodingService;

    @Autowired
    private RobotService robotService;

    public BaseResponse<?> voice(AndroidRequest androidRequest) {

        SpeechRequest speechRequest = new SpeechRequest();
        MultipartFile multipartFile = androidRequest.getMultipartFile();
        String originalFilename = multipartFile.getOriginalFilename();
        File file = new File("d:/tmp/" + UUID.randomUUID().toString().toLowerCase() + originalFilename.substring(originalFilename.indexOf(".")));
        byte[] data = null;
        try {

            Util.writeBytesToFileSystem(multipartFile.getBytes(), file.getAbsolutePath());

        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }

        String pcmSpeech = speechCodingService.getPcmSpeech(file);

        try {
            if (pcmSpeech != null) {
                data = SpeechDecodingUtil.readFileByBytes(pcmSpeech);
            } else {
                return new BaseResponse(Integer.valueOf(BackCode.SPEECH_PARSING_FAILED.getIndex()), BackCode.SPEECH_PARSING_FAILED.getName());

            }
            speechRequest.setData(data);

        } catch (IOException e) {
            logger.error(String.format("解析语音失败 Exception =%s", ExceptionUtils.getStackTrace(e)));
            return new BaseResponse(Integer.valueOf(BackCode.SPEECH_PARSING_FAILED.getIndex()), BackCode.SPEECH_PARSING_FAILED.getName());
        }
        speechRequest.setFormat("pcm");

        logger.info(String.format("语音识别开始 =========>语音文件 =%s", pcmSpeech));
        BaiduSdkResponse baiduSdkResponse = speechRecognitionClient.voiceToText(speechRequest);

        return getResult(baiduSdkResponse);
    }

    @Override
    public BaseResponse<?> talk(TalkRequest talkRequest) {

        SpeechRequest speechRequest = new SpeechRequest();

        speechRequest.setFormat(talkRequest.getType());

        speechRequest.setData(talkRequest.getVoice());

        BaiduSdkResponse baiduSdkResponse = speechRecognitionClient.voiceToText(speechRequest);

        return getResult(baiduSdkResponse);
    }


    private BaseResponse<?> getResult(BaiduSdkResponse baiduSdkResponse) {

        //错误码不等于0表示 语音识别失败
        if (baiduSdkResponse.getErr_no() != 0) {
            logger.error(String.format("语音识别异常 err_no= %s ,err_msg= %s", baiduSdkResponse.getErr_no(), baiduSdkResponse.getErr_msg()));
            return new BaseResponse(baiduSdkResponse.getErr_no(), baiduSdkResponse.getErr_msg(), baiduSdkResponse);
        }
        String tex = baiduSdkResponse.getResult()[0];

        logger.info(String.format("语音识别结束 语音id =%s ,结果 =%s", baiduSdkResponse.getSn(), tex));
        hanLpService.LexicalAnalysis(tex);
        RobotResponse talk = robotService.talk(tex);

        return new BaseResponse<>(talk);

    }
}
