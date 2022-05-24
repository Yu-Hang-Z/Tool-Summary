package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


/**
 * @author by zhangyuhang
 * @Classname RestTelmplateDemo
 * @Description TODO
 * @Date 2022/5/24 21:53
 */
@RestController
public class RestTelmplateDemo {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/restTelmplate")
    public String hello(String name) {
        ResponseEntity<String> result;
        String url = "http://127.0.0.1:8080";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("name", name);
        HttpEntity requestEntity = new HttpEntity(map,httpHeaders);
        String controllerPath = url + "/hello";
        result = restTemplate.postForEntity(controllerPath, requestEntity, String.class);
        return result.getBody();
    }

}
