package com.ft.first.restTemplate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestRestTemplate01 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getFOrObject")
    public Map<String, Object> getForObject() {
        //远程访问的url
        String url = "http://47.113.91.59:8080/getExtendUserRanking?type=0";
        //请求的入参
        Map<String, Object> paramMap = new HashMap<>();
        //url代表请求的地址，XXX.class代表放回的类型，paramMap代表要传入的参数
        Map<String, Object> rest = restTemplate.getForObject(url, Map.class, paramMap);
        System.out.println(rest);
        return rest;
    }

    @GetMapping("/getForEntity")
    public Map<String,Object> getForEntity(){
        //远程访问的url
        String url = "http://47.113.91.59:8080/getExtendUserRanking?type=0";
        //请求的入参
        Map<String, Object> paramMap = new HashMap<>();
        ResponseEntity<HashMap> responseEntity=restTemplate.getForEntity(url,HashMap.class,paramMap);
        //状态码
        HttpStatus statusCode=responseEntity.getStatusCode();
        System.out.println(statusCode);
        int statusCodeValue=responseEntity.getStatusCodeValue();
        System.out.println(statusCodeValue);
        //请求头
        HttpHeaders httpHeaders=responseEntity.getHeaders();
        System.out.println(httpHeaders);
        return responseEntity.getBody();
    }
}
