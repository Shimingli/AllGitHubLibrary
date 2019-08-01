package com.lsm.update.http;


import java.util.Map;


public class DownloadModel {

    /**
     * 请求地址
     */
    private String httpUrl;
    /**
     * 请求头
     */
    private Map<String, String> headersMap;
    /**
     * 请求Tag
     */
    private Object tag;
    /**
     * 下载文件保存的路径
     */
    private String downloadPath;
    /**
     * 文件下载进度
     */
    private BaseFileProgressCallback fileProgressCallback;


    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }

    public Map<String, String> getHeadersMap() {
        return headersMap;
    }

    public void setHeadersMap(Map<String, String> headersMap) {
        this.headersMap = headersMap;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public BaseFileProgressCallback getFileProgressCallback() {
        return fileProgressCallback;
    }

    public void setFileProgressCallback(BaseFileProgressCallback fileProgressCallback) {
        this.fileProgressCallback = fileProgressCallback;
    }
}
