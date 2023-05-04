package com.cj.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {

    //读取配置文件内容
    @Value("oss-cn-chengdu.aliyuncs.com")
    private String endpoint;

    @Value("LTAI5tQzQ53G5C2Wm3ryiZd5")
    private String keyId;

    @Value("53dL8SKlLUDh6IayvfS01gQ0fMpl5e")
    private String keySecret;

    @Value("educdutpj")
    private String bucketName;

    public static String END_POINT;

    public static String ACCESS_KEY_ID;

    public static String ACCESS_KEY_SECRET;

    public static String BUCKET_NAME;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;

        ACCESS_KEY_ID = keyId;

        ACCESS_KEY_SECRET = keySecret;

        BUCKET_NAME = bucketName;

    }
}
