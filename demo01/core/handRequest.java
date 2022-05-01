package com.demo01.core;

import java.io.IOException;
import java.io.InputStream;

public class handRequest {
    public static Request hand(InputStream inputStream) throws IOException {
        byte[] buf = new byte[1024];
        int len;
        StringBuilder stringBuilder = new StringBuilder();

        do {
            //read方法会阻塞
            len = inputStream.read(buf);
            if (len != -1){
                stringBuilder.append(new String(buf,0,len));
            }

        }while (inputStream.available()>0);

        String str = stringBuilder.toString();
        Request request = new Request();
        String[] split1 = str.split("\r\n\r\n");
        if (split1.length > 1){
            request.setBody(split1[1]);
        }
        String[] split2 = split1[0].split("\r\n");
        String line = split2[0];
        String[] s = line.split(" ");
        request.setType(s[0]);

        //url里可能有参数/user?name=zs&id=1
        String[] urlAndPara = s[1].split("\\?");
        request.setUrl(urlAndPara[0]);
        if (urlAndPara.length>1 && urlAndPara[1] != null){
            //url里有参数
            String[] paras = urlAndPara[1].split("&");
            for (String para : paras) {
                String[] nameAndValue = para.split("=");
                request.setParameters(nameAndValue[0],nameAndValue[1]);
            }


        }

        request.setProtocol(s[2]);
        for (int i = 1; i < split2.length -1 ; i++) {
            String[] split = split2[i].split(": ");
            request.getHeader().put(split[0],split[1]);
        }
        return  request;
    }
}
