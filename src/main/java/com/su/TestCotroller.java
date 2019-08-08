package com.su;

import com.su.util.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MAA")
public class TestCotroller {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toLogin1")
    public String toLogin1(){
        HttpUtil.doJsonPost("https://www.baidu.com","");
        return "login1";
    }


}
