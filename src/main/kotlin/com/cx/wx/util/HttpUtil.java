package com.cx.wx.util;

import com.cx.wx.model.AccessToken;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {
    // also: public <T> T sendGet(Class<T> clazz)

    /**
     * 发送Get方法
     * <T>: 声明此方法持有一个类型T
     * ResponseEntity<T>: 声明此方法的返回类型, 也可直接返回T
     * Class<T>: 指明T的具体类型, 由外部传入
     * @param url
     * @param clazz
     * @param <T>
     * @return 响应实体
     */
    public static <T> ResponseEntity<T> sendGet(String url, Class<T> clazz) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        Map param = new HashMap<String, String>();
        HttpEntity requestEntity = new HttpEntity<>(param, header);

        HttpMethod method = HttpMethod.GET;

        return rt.exchange(url, method, requestEntity, clazz);
    }

    /**
     * 发送Post方法
     * @param url
     * @param param
     * @param clazz
     * @param <T>
     * @return 响应实体
     */
    public static <T> ResponseEntity<T> sendPost(String url, Map<String, Object> param, Class<T> clazz) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        HttpMethod method = HttpMethod.POST;

        HttpEntity requestEntity = new HttpEntity<>(param, header);

        return rt.exchange(url, method, requestEntity, clazz);
    }
}
