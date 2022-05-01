package com.demo01.util;

import java.io.*;

public class ioUtil {
    //根据文件路径去把文件读进来
    public static String getFile(String path){
        File file = new File(path);
        if (!file.exists()){
            return null;
        }


        StringBuilder stringBuilder = null;

        try (
                InputStream fileInputStream = new FileInputStream(path);
                )
        {
            byte[] buf = new byte[1024];
            int len;
            stringBuilder = new StringBuilder();
            while ((len = fileInputStream.read(buf)) != -1){
                stringBuilder.append(new String(buf,0,len));
                }
            } catch (Exception e) {
               return null;
        }
        if (stringBuilder != null){
            return stringBuilder.toString();
        }
        return null;
    }
}
