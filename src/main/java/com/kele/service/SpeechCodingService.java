package com.kele.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 语音编码服务
 */
public interface SpeechCodingService {

   String getPcmSpeech(File multipartFile);
}
