package com.su.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * NieSu 2018/1/28
 */
public class HttpUtil
{
  private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

  //发送JSON字符串 如果成功则返回成功标识。
  public static String doJsonPost(String urlPath, String Json) {
    // HttpClient 6.0被抛弃了
    String result = "";
    BufferedReader reader = null;
    try {
      URL url = new URL(urlPath);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);
      conn.setRequestProperty("Connection", "Keep-Alive");
      conn.setRequestProperty("Charset", "UTF-8");
      // 设置文件类型:
      conn.setRequestProperty("Content-Type","application/json; charset=UTF-8");
      // 设置接收类型否则返回415错误
      //conn.setRequestProperty("accept","*/*")此处为暴力方法设置接受所有类型，以此来防范返回415;
      conn.setRequestProperty("accept","application/json");
      // 往服务器里面发送数据
      if (Json != null && !StringUtils.isEmpty(Json)) {
        byte[] writebytes = Json.getBytes();
        // 设置文件长度
        conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
        OutputStream outwritestream = conn.getOutputStream();
        outwritestream.write(Json.getBytes());
        outwritestream.flush();
        outwritestream.close();
        logger.info("hlhupload", "doJsonPost: conn"+conn.getResponseCode());
      }
      if (conn.getResponseCode() == 200) {
        reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));
        result = reader.readLine();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }

}
