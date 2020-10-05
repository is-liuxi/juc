package cn.hniu.mooc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author: liuxi
 * @date: 2020/10/6
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private Integer count = 1;

    @GetMapping("hello")
    public String hello() {
        log.info("请求次数：" + count++);
        return "hello world";
    }
}
