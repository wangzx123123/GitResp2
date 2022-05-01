package com.demo01.core;

import java.util.HashMap;

public class Request {
    private String protocol;
    private  String type;
    private  String url;
    private HashMap<String ,String> header = new HashMap<>();
    private String body;

    //请求参数
    private HashMap<String , String> parameters = new HashMap<>();

    public  HashMap getParameters(){
        return this.parameters;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getHeader() {
        return header;
    }

    public void setHeader(HashMap<String, String> header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String  getParameters(String name) {
        return parameters.get(name);
    }

    public void setParameters(String name,String value) {
        this.parameters.put(name,value);
    }

    @Override
    public String toString() {
        return "Request{" +
                "\nprotocol='" + protocol + '\'' +
                ", \ntype='" + type + '\'' +
                ", \nurl='" + url + '\'' +
                ", \nheader=" + header +
                ", \nbody='" + body + '\'' +
                ", \nparameters=" + parameters +
                '}';
    }
}
