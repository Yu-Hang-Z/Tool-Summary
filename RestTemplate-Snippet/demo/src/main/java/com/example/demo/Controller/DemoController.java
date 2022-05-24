package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by zhangyuhang
 * @Classname DemoController
 * @Description TODO
 * @Date 2022/5/24 21:49
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        String result = "Hello " + name;
        return result;
    }
}
