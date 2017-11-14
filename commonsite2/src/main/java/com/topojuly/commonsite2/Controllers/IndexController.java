package com.topojuly.commonsite2.Controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
    public String Index(Map<String,Object> map){

        map.put("title","网站登陆页面");
        return "/Index";
    }
	
	@RequestMapping("/Main")
	public String Main(Map<String,Object> map) {
		map.put("title","网站登陆页面");
		return "/Main";
	}
}
