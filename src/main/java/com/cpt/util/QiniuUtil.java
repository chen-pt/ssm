package com.cpt.util;


import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * 版权所有(C) 2017 
 * 描述:
 * 作者: chen_pt
 * 创建日期: 2017/11/10
 * 修改记录:
 */
public class QiniuUtil {
    private static Logger logger = LoggerFactory.getLogger(QiniuUtil.class);

    private static String ACCESS_KEY = "PwBXXSIyqY1gAeFjTAgP3IYLkli5SaC_d0xtF1p3";
    private static String SECRET_KEY = "29oEyBk1qGX6vbzPrlHhlIMcHozKdoEEb1Q1c-Iu";
    private static String bucketName = "imgs";


    public String getQiniuToken(){
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        // 请确保该bucket已经存在
        String bucketName = "Your bucket name";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = null;
        try {
            uptoken = putPolicy.token(mac);
        } catch (AuthException e) {
            logger.error("获取七牛token",e);
        } catch (JSONException e) {
            logger.error("获取七牛token",e);
        }

        return uptoken;
    }

    public void uploadFile() {
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = null;
        try {
            uptoken = putPolicy.token(mac);
        } catch (AuthException e) {
            logger.error("获取七牛token",e);
        } catch (JSONException e) {
            logger.error("获取七牛token",e);
        }
        PutExtra extra = new PutExtra();
        String key = "demo";
        String localFile = "C:\\Users\\Public\\Pictures\\Sample Pictures\\car.jpg";
        PutRet ret = IoApi.putFile(getQiniuToken(), key, localFile, extra);


        System.out.println(ret.getKey()+ret.getHash());
    }

    public static void main(String args[]){
        QiniuUtil qiniuUtil = new QiniuUtil();
        qiniuUtil.uploadFile();
    }

}
