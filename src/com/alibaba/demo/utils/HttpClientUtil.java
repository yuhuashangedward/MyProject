package com.alibaba.demo.utils;

import java.util.Map;

public class HttpClientUtil {

    private String rootUrl;
    private CloseableHttpClient httpClient;

    public enum Method {
        GET,POST
    }

    private HttpClientUtil(String rootUrl){
        this.rootUrl = rootUrl;
    }

    public static  HttpClientUtil createInstance(String rootUrl){
        return new HttpClientUtil(rootUrl);
    }

    public String sendMessage(String relativeUrl,Map<String,Object> requestMap) throws Exception{
        return this.sendMessage(relativeUrl, requestMap,HttpClientUtil.Method.GET);
    }

    public String sendMessage(String relativeUrl) throws Exception{
        return this.sendMessage(relativeUrl, null,HttpClientUtil.Method.GET);
    }

    public String sendMessage(String relativeUrl,Map<String,Object>requestMap,Method method) throws Exception{
        if(httpClient==null){
            httpClient = HttpClientBuilder.create().build();
        }
        String absluteUrl = rootUrl+relativeUrl;
        HttpUriRequest req = null;
        if(method==null){
            method = Method.GET;
        }
        if(method==Method.POST){
            HttpPost hp = new HttpPost(absluteUrl);
            if(requestMap!=null){
                List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
                for(String key:requestMap.keySet()){
                    Object value = requestMap.get(key);
                    if(value!=null){
                        nvps.add(new BasicNameValuePair(key, value.toString()));

                    }
                }
                hp.setEntity(new UrlEncodedFormEntity(nvps,Consts.UTF_8));
            }
            req = hp;
        }else{
            if(requestMap!=null){
                List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
                for(String key:requestMap.keySet()){
                    Object value = requestMap.get(key);
                    if(value!=null){
                        nvps.add(new BasicNameValuePair(key, value.toString()));

                    }
                }
                String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps,Consts.UTF_8));
                if(absluteUrl.indexOf("?")>=0){
                    absluteUrl = absluteUrl+"&"+str;
                }else{
                    absluteUrl = absluteUrl+"?"+str;
                }
            }
            req = new HttpGet(absluteUrl);
        }
        try {
            CloseableHttpResponse htrp = httpClient.execute(req);
            int statuscode = htrp.getStatusLine().getStatusCode();
            if(statuscode!=200){
                throw new Exception("返回错误：状态码"+statuscode);
            }else{
                String responseString = EntityUtils.toString(htrp.getEntity()).trim();
                return responseString;
            }
        } catch (ClientProtocolException e) {
            throw new Exception("URL地址错误",e);
        } catch (IOException e) {
            throw new Exception("传输错误",e);
        }
    }
}
