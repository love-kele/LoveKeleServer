package com.kele.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GsonUtil {

    private static Logger logger = LoggerFactory.getLogger(GsonUtil.class);

    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    private static Gson camelGson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd").create();

    public static Gson buildGson() {
        return gson;
    }

    public static Gson buildCommGson() {
        return camelGson;
    }

    /**
     * 将字符串转换成JavaBean
     * @param json
     * @param clazz
     */
    public static <T> T jsonToBean(String json, Class<T> clazz) {
        T bean = null;
        try {
            bean = gson.fromJson(json, clazz);
        } catch (JsonSyntaxException e) {
            logger.error(String.format("将字符串转换成JavaBean: %s", ExceptionUtils.getStackTrace(e)));
            throw e;
        }
        return bean;
    }

    public static <T> T jsonToObj(String json) throws Exception {
        try {
            return gson.fromJson(json,new TypeToken<T>(){}.getType());
        }catch (Exception e){
            logger.error(String.format("jsonToObj: %s",ExceptionUtils.getStackTrace(e)));
            throw e;
        }
    }

    public static String beanToJson(Object bean){
        return gson.toJson(bean);
    }
}
