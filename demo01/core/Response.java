package com.demo01.core;

import java.io.OutputStream;
import java.util.HashMap;

public class Response {
    private String protocol = "http/1.1";
    private String code = "200";
    private String message = "ok";
    //响应头
    HashMap<String , String> header = new HashMap<>();
    private String body;
    private OutputStream outputStream;








    @Override
    public String toString() {
        return "Response{" +
                "protocol='" + protocol + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", header=" + header +
                ", body='" + body + '\'' +
                '}';
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHeader(String key) {
        return header.get(key);
    }
    public HashMap<String ,String> getHeaders() {
        return header;
    }
    public void setHeader(String key,String value) {
        this.header.put(key,value);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
