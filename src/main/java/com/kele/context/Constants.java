package com.kele.context;

public class Constants {

    public static class Common {

        public static final Integer rate = 16000;//采样率

        public static final String PCM = "pcm";

        public static final String WAV = "wav";

        public static final String AMR = "amr";

        public static final String DEV_PID="dev_pid";

        public static final String ROBOT_API="http://openapi.tuling123.com/openapi/api/v2";

    }

    public static class LangType {

        public static final Integer PuTongHua_Model_Serach = 1536; //普通话 搜索模型

        public static final Integer PuTongHua_Model_Input = 1573;//普通话 输入法模型

        public static final Integer English = 1737;//英语

        public static final Integer Cantonese = 1637;//粤语

        public static final Integer SiChuanHua = 1837;//四川话

        public static final Integer PuTongHua_Model_Serach_Far_Filed = 1936;//普通话 远场模型

    }

    public static class FFmpegConfig{


        /**
         * 编码后文件所放的位置
         */
        public static final String DEV_BASE_PATH="d:/ffmpeg/speech/";


        public static class Command{


            //ffmpeg -y  -i 16k.wav  -acodec pcm_s16le -f s16le -ac 1 -ar 16000 16k.pcm
            public static  String WAV_TO_PCM="ffmpeg -y -i @%@&* -acodec pcm_s16le -f s16le -ac 1 -ar 16000 ($%#@)";


            public static String getWavToPcm(String in,String out){

                return WAV_TO_PCM.replace("@%@&*",in).replace("($%#@)",out);
            }
        }
    }

}
